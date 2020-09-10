package ru.cherniak.spring.context.training_manual.do_DI_scope;

import org.springframework.stereotype.Component;

@Component
class ColorCameraRollImpl implements CameraRoll {
    @Override
    public void processing() {
        System.out.println("ColorPhoto taken");
    }
}
