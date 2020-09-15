package ru.cherniak.spring.context.training_manual.do_init_context_levels;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;


@Component("photocameraTestBeanPostProcessor")
public class PhotocameraTestBeanPostProcessorImpl implements BeanPostProcessor {
    /*
    реализация этого интерфейса позволит получать доступ к каждому бину поочередно.
    В каждый из методов передается сам бин и его имя.
     */

    //Этот дефолтнай метод можно не переопредлять - в интерфейсе аналогичная реализация
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    /*
    Предположим, что помощник перед покупкой фотоаппарата решил проверить его работоспособность.
    Для этого ему необходимо самому попробовать сделать фотографию.
    Для осуществления этой затеи реализуем собственный BeanPostProcessor:

     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        // Находим бин класса фотокамеры
        if (bean instanceof Camera) {
            System.out.println("\nДелаю пробное фото!");
            // Делаем пробное фото
            ((Camera) bean).doPhoto();
            System.out.println("Отлично! Работает!\n");
        }
        return bean;
    }
}
