package fr.rozanc.sandbox.a;

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
@ComponentScan(basePackageClasses = {BaseBean.class, AService.class})
@Configuration
@Lazy
public class AConfig extends BaseConfig {

    @Bean
    MyService myService() {
        System.out.println("a Creating myService bean");
        return new AService();
    }
}
