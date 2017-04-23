package fr.rozanc.sandbox;

import fr.rozanc.sandbox.a.MyBean;
import fr.rozanc.sandbox.b.MyBean2;

public class App {
    public static void main(String[] args) {
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AConfig.class);
        MyBean mb = new MyBean();
        mb.doSomething();
//        ctx.close();

//        ctx = new AnnotationConfigApplicationContext(BConfig.class);
        MyBean2 mb2 = new MyBean2();
        mb2.doSomething();
//        ctx.close();

//        ctx = new AnnotationConfigApplicationContext(AConfig.class);
        MyBean mb3 = new MyBean();
        mb3.doSomething();
//        ctx.close();
    }
}
