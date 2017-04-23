package fr.rozanc.sandbox;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component("baseBeanPostProcessor")
public class BaseBeanPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Before init " + beanName);
//        if (bean instanceof BaseBean) {
//            ((BaseBean) bean).init = true;
//            return null;
//        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("After init " + beanName);
        return bean;
    }
}
