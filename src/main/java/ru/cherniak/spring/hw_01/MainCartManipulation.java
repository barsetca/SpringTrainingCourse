package ru.cherniak.spring.hw_01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class MainCartManipulation {

    public static void main(String[] args) {
        long[] ids = {1L, 2L, 3L, 4L, 5L, 6L};
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfigHw.class);
        ProductRepository pr = ctx.getBean("productRepository", ProductRepository.class);
        System.out.println("Содержимое ProductRepository:");
        pr.findAll().forEach(System.out::println);

        System.out.println("\nДостаем из ProductRepository продукт с id = 3L");
        System.out.println(pr.getProduct(3L));

        System.out.println("\nДостаем из ProductRepository продукт с несущестующим id = 7L");
        System.out.println(pr.getProduct(7L));

        System.out.println("\nСоздаем и заполняем первую корзину");
        Cart cart01 = ctx.getBean("cart", Cart.class);
        for (int i = 0; i < ids.length; i += 2) {
            cart01.addProduct(ids[i]);
        }
        cart01.findAll().forEach(System.out::println);

        System.out.println("\nСоздаем и заполняем вторую корзину");

        Cart cart02 = ctx.getBean("cart", Cart.class);
        for (long id : ids) {
            cart02.addProduct(id);
        }
        cart02.findAll().forEach(System.out::println);

        System.out.println("\nСозданные корзины один и тоже объкет? - " + (cart01.hashCode() == cart02.hashCode()));

        System.out.println("\nУдаляем из первой корзины один продукт с id = 1L");
        int sizeCart01BeforeRemove = cart01.findAll().size();
        cart01.removeProduct(1L);
        int sizeCart01AfterRemove = cart01.findAll().size();
        System.out.println("Размер первой корзины уменьшился на 1? - " + ((sizeCart01BeforeRemove - sizeCart01AfterRemove) == 1));

        System.out.println("\nУдаляем из второй корзины всё содержимое");
        Arrays.stream(ids).forEach(cart02::removeProduct);
        System.out.println("Вторая корзина пуста? - " + cart02.findAll().isEmpty());
        System.out.println();
        System.out.println("Размер первой корзины = " + cart01.findAll().size());
        System.out.println("Размер второй корзины = " + cart02.findAll().size());
    }
}
