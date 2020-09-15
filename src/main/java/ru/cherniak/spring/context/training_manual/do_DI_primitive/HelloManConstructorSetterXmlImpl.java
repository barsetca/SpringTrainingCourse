package ru.cherniak.spring.context.training_manual.do_DI_primitive;

public class HelloManConstructorSetterXmlImpl implements HelloMan {
    private String name;

    public HelloManConstructorSetterXmlImpl() {
    }

    public HelloManConstructorSetterXmlImpl(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void helloSay() {
        System.out.println("Hello," + this.name);
    }

}
