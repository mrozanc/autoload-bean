package fr.rozanc.sandbox.a;

import fr.rozanc.sandbox.BaseBean;
import fr.rozanc.sandbox.LoadContext;
import fr.rozanc.sandbox.MyService;
import fr.rozanc.sandbox.b.BConfig;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

@LoadContext(AConfig.class)
@Configurable(autowire = Autowire.BY_NAME)
@Component
public class MyBean extends BaseBean {

    @SuppressWarnings("SpringAutowiredFieldsWarningInspection")
    @Autowired
    private MyService myService;

    public MyBean() {
        super(BConfig.class);
        System.out.println("MyBean()");
    }

    public void doSomething() {
        System.out.println("MyBean.doSomething()");
        myService.doSomething();
    }
}
