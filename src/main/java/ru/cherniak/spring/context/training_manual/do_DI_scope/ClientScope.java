package ru.cherniak.spring.context.training_manual.do_DI_scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ClientScope {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfigDI.class);

        Camera camera = ctx.getBean("cameraImpl", Camera.class);
        camera.doPhoto();
        camera.breaking();
        camera.doPhoto();
        System.out.println("Камера сломана? - " + camera.isBroken());

        //если для бина используется scope по умолчанию (singleton), то от создания нового объекта ничего не изменится,
        // т.к это будет все тот же объект, т.е. камера будет попрежнему сломана
        Camera newCamera = ctx.getBean("cameraImpl", Camera.class);
        System.out.println("Камера сломана - " + newCamera.isBroken()); //true

        //Создадим еще одну реализацию Camera - CameraPrototypeImpl, но со @Scope("prototype")
        //название бина пишется с маленькой буквы - для автоматического определения или задать в @Component

        Camera cameraProto = ctx.getBean("cameraPrototypeImpl", Camera.class);
        cameraProto.doPhoto();
        System.out.println("\ncameraProto сломана? - " + cameraProto.isBroken());
        cameraProto.breaking();
        cameraProto.doPhoto();
        System.out.println("cameraProto сломана? - " + cameraProto.isBroken());

        // т.к @Scope("prototype")< то это будет новый объект, т.е. камера будет рабочей
        Camera newCameraProto = ctx.getBean("cameraPrototypeImpl", Camera.class);
        System.out.println("\nnewCameraProto сломана - " + newCameraProto.isBroken()); //false

        ctx.close();

    }

}
