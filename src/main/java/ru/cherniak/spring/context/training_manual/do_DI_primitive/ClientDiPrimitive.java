package ru.cherniak.spring.context.training_manual.do_DI_primitive;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientDiPrimitive {
    public static void main(String[] args) {
        // xml через консруктор
        ApplicationContext ctx = new ClassPathXmlApplicationContext("config-di-primitive.xml");
        HelloMan helloMan = ctx.getBean("helloMan", HelloMan.class);
        helloMan.helloSay();

// xml через сеттер
        HelloMan helloManConstructor = ctx.getBean("helloManSetter", HelloMan.class);
        helloManConstructor.helloSay();

// configFile через конструктор
        ApplicationContext contextFile = new AnnotationConfigApplicationContext(AppConfigDIPrimitive.class);
        HelloMan helloManFile = contextFile.getBean("helloManSetter", HelloMan.class);
        helloManFile.helloSay();


    }

}
