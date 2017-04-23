package fr.rozanc.sandbox;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public aspect BaseBeanContextAspect implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    pointcut newBaseBean(): initialization(public fr.rozanc.sandbox.BaseBean+.new(Class<? extends BaseConfig>));

//    pointcut newLoadContext(): call(public fr.rozanc.sandbox.BaseBean+.new(..))
//            && target(@org.springframework.beans.factory.annotation.Configurable *);

    pointcut preInitLoadContext(): preinitialization(*.new(..)) && @within(fr.rozanc.sandbox.LoadContext);

    before(): newBaseBean() {
        System.out.println("weaving " + thisJoinPoint.getTarget().getClass().getSimpleName());
//            ApplicationContextProvider.getApplicationContext((Class<?>) thisJoinPoint.getArgs()[0]);
    }

//    before(): newLoadContext() {
////        System.out.println("loadcontext " + thisJoinPointStaticPart.getSignature().getDeclaringType().getAnnotations());
//        for (Annotation a : thisJoinPointStaticPart.getSignature().getDeclaringType().getAnnotations()) {
//            System.out.println("loadcontext " + a.toString());
//        }
//    }
    private volatile boolean init = false;

    before(): preInitLoadContext() {
        System.out.println("preInitLoadContext " + thisJoinPointStaticPart.getSourceLocation().getWithinType().getSimpleName());
        if (!init) {
            init = true;
            final LoadContext a = (LoadContext) thisJoinPointStaticPart.getSignature()
                                                                       .getDeclaringType()
                                                                       .getAnnotation(LoadContext.class);
            final Class<?>[] configurationClasses = a.value();
            if (configurationClasses != null && configurationClasses.length > 0) {
                final StringBuilder sb = new StringBuilder();
                for (Class<?> clazz : configurationClasses) {
                    sb.append(clazz.getCanonicalName());
                }
                final String contextId = sb.toString();
                if (applicationContext != null && applicationContext.getId().equals(contextId)) {
                    return;
                }
                final AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                        configurationClasses);
                ctx.setId(contextId);
                applicationContext = ctx;
            }
            init = false;
        }
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

}
