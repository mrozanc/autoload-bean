package fr.rozanc.sandbox;

public abstract class BaseBean {

    public BaseBean(Class<? extends BaseConfig> configClass) {
        System.out.println("BaseBean()");
    }

    public abstract void doSomething();
}
