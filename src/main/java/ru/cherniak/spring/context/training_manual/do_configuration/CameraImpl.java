package ru.cherniak.spring.context.training_manual.do_configuration;

public class CameraImpl implements Camera {

    private CameraRoll cameraRoll;

    public CameraRoll getCameraRoll() {
        return cameraRoll;
    }

    @Override
    public void setCameraRoll(CameraRoll cameraRoll) {
        this.cameraRoll = cameraRoll;
    }


    @Override
    public void doPhoto() {
        System.out.println("The camera shutter worked");
        cameraRoll.processing();
    }
}
