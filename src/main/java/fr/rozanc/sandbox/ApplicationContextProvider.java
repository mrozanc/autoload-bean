package fr.rozanc.sandbox;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextProvider implements ApplicationContextAware {

    private static Map<Class<?>, ApplicationContext> contexts = new ConcurrentHashMap<Class<?>, ApplicationContext>();

    private static ApplicationContext currentContext;

    public static synchronized ApplicationContext getCurrentApplicationContext() {
        return currentContext;
    }

    public static ApplicationContext getApplicationContext(Class<?> configurationClass) {
        if (!contexts.containsKey(configurationClass)) {
            contexts.put(configurationClass, new AnnotationConfigApplicationContext(configurationClass));
        }
        return contexts.get(configurationClass);
    }

    public void setApplicationContext(ApplicationContext ac) throws BeansException {
        currentContext = ac;
    }
}
