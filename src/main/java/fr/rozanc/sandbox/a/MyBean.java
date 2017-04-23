package fr.rozanc.sandbox.a;

import fr.rozanc.sandbox.BaseBean;
import fr.rozanc.sandbox.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyBean extends BaseBean {

    @SuppressWarnings("SpringAutowiredFieldsWarningInspection")
    @Autowired
    private MyService myService;

    public MyBean() {
        super(AConfig.class);
    }

    public void doSomething() {
        System.out.println("a.MyBean.doSomething()");
        myService.doSomething();
    }
}
