package ru.cherniak.spring.context.training_manual.do_configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.cherniak.spring.context.training_manual.do_configuration.Camera;
import ru.cherniak.spring.context.training_manual.do_configuration.CameraImpl;
import ru.cherniak.spring.context.training_manual.do_configuration.CameraRoll;
import ru.cherniak.spring.context.training_manual.do_configuration.ColorCameraRollImpl;

/*
@Configuration — аннотация, указывающая на то, что данный Java-класс является классом конфигурации;
@Bean — используется для аннотирования методов, создающих бины в классе,
помеченном аннотацией @Configuration. Аналог тега <bean…../> в XML-конфигурации.
 */

@Configuration
@ComponentScan(basePackages = "ru.cherniak.spring.context.training_manual.do_configuration")
public class AppConfigWithoutXml {

    /*
    если указать бин cameraRoll, то он по сути переопределит класс бина при иниц-ии конекста
    из config-xml-annotation-component.xml и фото будет Color, не смотря на то что аннотацией
    @Component("cameraRoll") помечен MonoChromeCameraRollImpl
       */
    @Bean(name = "colorCameraRollImpl")
    public ColorCameraRollImpl colorCameraRollImpl(){
        return new ColorCameraRollImpl();
    }

    //название зависимости должно совпадать с названием бина colorCameraRollImpl
    //если написать cameraRoll, то подгрузиться бин с таким именем (если есть)
    // в нашем случае MonoChromeCameraRollImpl
    @Bean(name = "camera")
    public Camera camera(CameraRoll  colorCameraRollImpl){
        Camera camera = new CameraImpl();
        camera.setCameraRoll(colorCameraRollImpl);
        return camera;
    }
}
