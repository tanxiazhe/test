/**
 * 
 */
package com.designPattern.factory.abstractFactory;

/**
 * @author 
 *
 */
public class Client {
    public static void main(String[] args) {
        AbstractFactory abstractFactory = new ConcreteFactory1();
        abstractFactory.createProductA();
        abstractFactory.createProductB();

        abstractFactory = new ConcreteFactory2();
        abstractFactory.createProductA();
        abstractFactory.createProductB();
    }

}
