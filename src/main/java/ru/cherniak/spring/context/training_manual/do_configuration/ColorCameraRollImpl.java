package ru.cherniak.spring.context.training_manual.do_configuration;

import org.springframework.stereotype.Component;

@Component
public class ColorCameraRollImpl implements CameraRoll {
    @Override
    public void processing() {
        System.out.println("ColorPhoto taken");
    }
}
