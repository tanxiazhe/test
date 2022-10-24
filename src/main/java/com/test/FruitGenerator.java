package com.test;

import java.util.Random;

public class FruitGenerator implements Generator<String> {

    private final String[] fruits = new String[] { "Apple", "Banana", "Pear" };

    @Override
    public String next() {
        Random rand = new Random();
        return fruits[rand.nextInt(3)];
    }
    
    public static void main(String[] args) {
        FruitGenerator generator = new FruitGenerator();
        System.out.println(generator.next());
        System.out.println(generator.next());
        System.out.println(generator.next());
        System.out.println(generator.next());
    }
}