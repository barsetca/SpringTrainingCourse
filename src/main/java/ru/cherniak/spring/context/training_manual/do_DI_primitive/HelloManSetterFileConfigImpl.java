package ru.cherniak.spring.context.training_manual.do_DI_primitive;

import org.springframework.stereotype.Component;

@Component
public class HelloManSetterFileConfigImpl implements HelloMan{
    private String name;

    public HelloManSetterFileConfigImpl(){
    }

    public HelloManSetterFileConfigImpl(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void helloSay(){
        System.out.println("Hello from " + this.name);
    }

}
