package fr.rozanc.sandbox;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component("baseBeanPostProcessor")
public class BaseBeanPostProcessor implements BeanPostProcessor {

    private final ApplicationContext ctx;

    @Autowired
    public BaseBeanPostProcessor(final ApplicationContext ctx) {this.ctx = ctx;}

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Before init " + beanName);
        ctx.getAutowireCapableBeanFactory().autowireBean(bean);
//        if (bean instanceof BaseBean && !BaseBean.init) {
//            BaseBean.init = true;
//        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("After init " + beanName);
        return bean;
    }
}
