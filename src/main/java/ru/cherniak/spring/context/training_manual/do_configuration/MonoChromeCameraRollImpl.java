package ru.cherniak.spring.context.training_manual.do_configuration;

import org.springframework.stereotype.Component;

/*
@Component заставляет Spring-контейнер создать объект класса, к которому применена аннотация,
с id, указанным в скобках.
Данный объект сразу же будет являться бином — а значит, компонентом, управляемым контейнером.
В файле конфигурации(config-xml-annotation-component.xml)
необходимо указать Spring-контейнеру, где искать классы, помеченные данной аннотацией.

@UnproducableCameraRoll(usingCameraRollClass = ColorCameraRollImpl.class) -
кастомная @ ДЛЯ ПОДМЕНЫ класса пленки во время второго этапа инициализации контекста
с использоваием кастомного класса настройщика UnproducableCameraRollBeanFactoryPostProcessor
implements BeanFactoryPostProcessor
 */
@Component("cameraRoll")
public class MonoChromeCameraRollImpl implements CameraRoll{
    @Override
    public void processing() {
        System.out.println("BlackAndWhite photo taken");
    }
}
