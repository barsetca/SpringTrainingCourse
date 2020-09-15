package ru.cherniak.spring.context.training_manual.do_configuration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientConfig {
    public static void main(String[] args) {

        System.out.println("\nwithout Spring - BlackAndWhite");
        CameraImpl camera = new CameraImpl();
        camera.setCameraRoll(new MonoChromeCameraRollImpl());
        camera.doPhoto();

        System.out.println("\nconfig-only-xml.xml - Color");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("config-only-xml.xml");
        Camera colorCamera = ctx.getBean("camera", Camera.class);
        colorCamera.doPhoto();

        System.out.println("\nconfig-xml-annotation-component.xml - BlackAndWhite");
        ApplicationContext ctxAnnotation =
                new ClassPathXmlApplicationContext("config-xml-annotation-component.xml");
        Camera otherCamera = ctxAnnotation.getBean("camera", Camera.class);
        otherCamera.doPhoto();


        System.out.println("\nAppConfigWithoutXml - Color");
        //если поместить файл конфигурации в ту же папку то он имеет приоритет перед xml
        ApplicationContext ctxConfigFile = new AnnotationConfigApplicationContext(AppConfigWithoutXml.class);
        Camera fileCamera = ctxConfigFile.getBean("camera", Camera.class);
        fileCamera.doPhoto();
    }
    /*
    Советы в выборе способа конфигурации
XML-конфигурация и JavaConfig являются двумя равнозначными способами конфигурации в Spring.
Но JavaConfig все же обладает весомыми преимуществами перед XML-конфигурацией:
Используется Java-код, а значит, не нужно заботиться о xsd-схемах и XML-тегах.
Можно выявить ошибки на этапе написания конфигурационного класса.
Больше гибкости за счет работы с объектами и методами.
Вывод: наилучшим способом конфигурации является JavaConfig,
но по возможности на протяжении курса будет приводиться и XML-аналог конфигурации.
Стоит ли применять конфигурацию с помощью аннотаций совместно с JavaConfig? Однозначно стоит.
Оптимальный способ — условие, согласно которому все бины, необходимые для инфраструктуры приложения
(источники данных, менеджеры транзакций), объявляются непосредственно в классе JavaConfig путем создания
метода и применения к нему аннотации @Bean. А ко всем классам, реализующим написанную нами бизнес-логику
(либо к классам, предназначенным для хранения какой-либо информации), применяются специальные аннотации
(@Component, @Service, @Repository и т. п.)
     */
}
