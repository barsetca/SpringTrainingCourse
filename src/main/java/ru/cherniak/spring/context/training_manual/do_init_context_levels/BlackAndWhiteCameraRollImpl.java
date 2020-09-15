package ru.cherniak.spring.context.training_manual.do_init_context_levels;

import org.springframework.stereotype.Component;


/*
@Component заставляет Spring-контейнер создать объект класса, к которому применена аннотация,
с id, указанным в скобках.
Данный объект сразу же будет являться бином — а значит, компонентом, управляемым контейнером.
В файле конфигурации(config-xml-annotation-component.xml)
необходимо указать Spring-контейнеру, где искать классы, помеченные данной аннотацией.


 */
@Component
@UnproducableCameraRoll(usingCameraRollClass = ColorCameraRollImpl.class)
class BlackAndWhiteCameraRollImpl implements CameraRoll {
    @Override
    public void processing() {
        System.out.println("BlackAndWhite photo taken");
    }
}
