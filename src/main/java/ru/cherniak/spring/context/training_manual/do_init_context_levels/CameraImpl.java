package ru.cherniak.spring.context.training_manual.do_init_context_levels;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
class CameraImpl implements Camera {

    // @Autowired - DI (перед полем не рекомендуется, либо перед конструкторомБ а лучше всего  - сеттер (см ниже)
    // @Qualifier(value = "colorCameraRollImpl") - усли есть 2е реализации то без это throw e NoUniqueBeanDefinitionException
    private CameraRoll cameraRoll;

    @Value("false")
    private boolean broken;

//    public CameraImpl(@Qualifier(value = "colorCameraRollImpl") CameraRoll cameraRoll) {
//        this.cameraRoll = cameraRoll;
//    }

    public CameraRoll getCameraRoll() {
        return cameraRoll;
    }

    @Override
    public void breaking() {
        this.broken = true;
    }

    @Override
    public boolean isBroken() {
        return broken;
    }

    @Autowired
    //@Qualifier(value = "colorCameraRollImpl")
    @Override
    public void setCameraRoll(CameraRoll cameraRoll) {
        this.cameraRoll = cameraRoll;
    }

    @Override
    public void doPhoto() {
        if (isBroken()) {
            System.out.println("The camera broken");
            return;
        }
        System.out.println("The camera shutter worked");
        cameraRoll.processing();
    }
}
