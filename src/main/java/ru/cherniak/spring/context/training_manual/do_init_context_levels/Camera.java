package ru.cherniak.spring.context.training_manual.do_init_context_levels;

public interface Camera {
    void doPhoto();

    void setCameraRoll(CameraRoll cameraRoll);

    CameraRoll getCameraRoll();

    void breaking();

    boolean isBroken();
}
