package fr.rozanc.sandbox.a;

import fr.rozanc.sandbox.MyService;
import org.springframework.stereotype.Component;

@Component
public class AService implements MyService {

    public void doSomething() {
        System.out.println("AService.doSomething()");
    }
}
