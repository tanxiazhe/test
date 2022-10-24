/**
 * 
 */
package com.designPattern.factory.factoryMethodPattern;

/**
 * @author 
 *
 */
public class Client {
    public static void main(String[] args) {
        Factory factory = new ConcreteFactoryA();
        factory.createProduct();

        factory = new ConcreteFactoryB();
        factory.createProduct();
    }
}
