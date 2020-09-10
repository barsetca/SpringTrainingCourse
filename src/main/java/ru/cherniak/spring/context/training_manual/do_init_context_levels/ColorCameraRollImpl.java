package ru.cherniak.spring.context.training_manual.do_init_context_levels;


class ColorCameraRollImpl implements CameraRoll {
    @Override
    public void processing() {
        System.out.println("ColorPhoto taken");
    }
}
