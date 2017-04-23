package fr.rozanc.sandbox;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public abstract class BaseBean {

    static volatile boolean init = false;

    private static ApplicationContext ctx;

    public BaseBean(final Class<? extends BaseConfig> configClass) {
        System.out.println("BaseBean()");
        if (ctx == null && !init) {
            System.out.println("  ctx == null && init == false");
            init = true;
            ctx = new AnnotationConfigApplicationContext(configClass);
            init = false;
        }
    }

}
