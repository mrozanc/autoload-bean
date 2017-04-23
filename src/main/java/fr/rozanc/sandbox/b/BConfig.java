package fr.rozanc.sandbox.b;

import fr.rozanc.sandbox.BaseBean;
import fr.rozanc.sandbox.BaseConfig;
import fr.rozanc.sandbox.MyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

@EnableLoadTimeWeaving(aspectjWeaving = EnableLoadTimeWeaving.AspectJWeaving.ENABLED)
@EnableSpringConfigured
@ComponentScan(basePackageClasses = {BaseBean.class, BService.class})
@Configuration
@Lazy
public class BConfig extends BaseConfig {

    @Bean
    MyService myService() {
        System.out.println("b Creating myService bean");
        return new BService();
    }
}
