package ru.cherniak.spring.context.training_manual.do_init_context_levels;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ClientInit {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfigDInit.class);

        Camera camera = ctx.getBean("cameraImpl", Camera.class);
        camera.doPhoto();
        camera.breaking();
        camera.doPhoto();
        System.out.println("Камера сломана? - "+ camera.isBroken());

        //если для бина используется scope по умолчанию (singleton), то от создания нового объекта ничего не изменится,
        // т.к это будет все тот же объект, т.е. камера будет попрежнему сломана
        Camera newCamera = ctx.getBean("cameraImpl", Camera.class);
        System.out.println("Камера сломана - "+ newCamera.isBroken()); //true

        ctx.close();

    }

}
