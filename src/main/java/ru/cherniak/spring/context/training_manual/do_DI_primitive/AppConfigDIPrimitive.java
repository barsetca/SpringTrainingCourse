package ru.cherniak.spring.context.training_manual.do_DI_primitive;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigDIPrimitive {
    @Bean(name = "helloManSetter")
    /*
    Аннотация @Value внедряет примитивное значение в элемент, к которому применена данная аннотация.
    Для внедрения зависимости name через сеттер достаточно воспользоваться пустым конструктором и использовать метод setName(name).
     */
    public HelloMan helloMan(@Value("Vasya") String name){
        return new HelloManSetterFileConfigImpl(name);
    }
}
