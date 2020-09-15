package ru.cherniak.spring.hw_01;

public class Util {
    private Util() {
    }

    public static void printWarning(long id) {
        System.out.println("Warning! Product id = " + id + " is not exists");
    }
}
