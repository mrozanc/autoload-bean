package fr.rozanc.sandbox.a;

import fr.rozanc.sandbox.BaseBean;
import fr.rozanc.sandbox.BaseConfig;
import fr.rozanc.sandbox.MyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackageClasses = {BaseBean.class, AService.class})
@Configuration
public class AConfig extends BaseConfig {

    @Bean
    MyService myService() {
        System.out.println("Creating myService bean");
        return new AService();
    }

    @Bean
    MyBean myBean() {
        return new MyBean();
    }
}
