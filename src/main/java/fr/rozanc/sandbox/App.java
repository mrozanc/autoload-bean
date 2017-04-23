package fr.rozanc.sandbox;

import fr.rozanc.sandbox.a.MyBean;

public class App {
    public static void main(String[] args) {
        MyBean mb = new MyBean();
        mb.doSomething();
        MyBean mb2 = new MyBean();
        mb2.doSomething();
    }
}
