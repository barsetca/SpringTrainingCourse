package ru.cherniak.spring.context.training_manual.do_init_context_levels;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "ru.cherniak.spring.context.training_manual.do_init_context_levels")
public class AppConfigDInit {
    @Bean(name = "cameraRollChangeBeanFactoryPostProcessor")
    public CameraRollChangeBeanFactoryPostProcessorImpl cameraRollChange(){
        return new CameraRollChangeBeanFactoryPostProcessorImpl();
    }

    @Bean(name = "photocameraTestBeanPostProcessorImpl")
    public PhotocameraTestBeanPostProcessorImpl photocameraTestBeanPostProcessorImpl(){
        return new PhotocameraTestBeanPostProcessorImpl();
    }
}
