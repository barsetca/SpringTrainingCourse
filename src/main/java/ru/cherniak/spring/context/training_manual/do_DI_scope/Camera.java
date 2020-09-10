package ru.cherniak.spring.context.training_manual.do_DI_scope;

public interface Camera {
    void doPhoto();
    void setCameraRoll(CameraRoll cameraRoll);
    CameraRoll getCameraRoll();
    void breaking();
    boolean isBroken();
    void ready();
    void end();

}
