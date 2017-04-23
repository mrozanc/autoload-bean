package fr.rozanc.sandbox.b;

import fr.rozanc.sandbox.MyService;
import org.springframework.stereotype.Component;

@Component
public class BService implements MyService {

    public void doSomething() {
        System.out.println("BService.doSomething()");
    }
}
