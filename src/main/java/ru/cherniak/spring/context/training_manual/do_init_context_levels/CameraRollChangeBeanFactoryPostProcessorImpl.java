package ru.cherniak.spring.context.training_manual.do_init_context_levels;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class CameraRollChangeBeanFactoryPostProcessorImpl implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        // Получение имен  BeanDefinition всех бинов, объявленных пользователем
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        // Перебор массива для получения доступа к каждому имени
        for (String name : beanDefinitionNames) {
            // Вывод информации о BeanDefinition
            System.out.println(name);
            // Получение BeanDefinition по имени
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);

            try {
                /*
                Получаем имя класса создаваемого бина, чтобы проверить,
                содержит ли он аннотацию UnproducableCameraRoll
                 */
                String beanDefinitionName = beanDefinition.getBeanClassName();
                // Проверяем на null, сто бы не поймать ClassNotFoundException
                if (beanDefinitionName != null){
                    // Получаем класс по имени
                    Class<?> beanClass = Class.forName(beanDefinition.getBeanClassName());
                    /*
                    Пытаемся получить объект аннотации и ее значение,
                    если  класс не содержит данную аннотацию, то  метод вернет null
                     */
                    UnproducableCameraRoll annotation = beanClass.getAnnotation(UnproducableCameraRoll.class);
                    if (annotation != null) {
                        // Получаем значение, указанное в параметрах аннотации (класс пленки, которую необходимо использовать)
                        Class usingCameraRollName = annotation.usingCameraRollClass();
                        System.out.println("BeanDefinitionClass BEFORE set = " + beanDefinitionName);
                        // Меняем класс будущего бина
                        beanDefinition.setBeanClassName(usingCameraRollName.getName());
                        System.out.println("BeanDefinitionClass AFTER set = " + beanDefinition.getBeanClassName());
                    }
                }

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            }
        // или хардкордный вариант
        /*
        BeanDefinition meBeanDefinition = beanFactory.getBeanDefinition("blackAndWhiteCameraRollImpl");
        try {
            Class<?> meBeanClass = Class.forName(meBeanDefinition.getBeanClassName());
            UnproducableCameraRoll meAnnotation =(UnproducableCameraRoll) meBeanClass.getAnnotation(UnproducableCameraRoll.class);
            Class usingCameraRollName = meAnnotation.usingCameraRollClass();
            // Меняем класс будущего бина
            meBeanDefinition.setBeanClassName(usingCameraRollName.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        */
        }
    }

