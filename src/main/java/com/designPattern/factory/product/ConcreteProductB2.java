/**
 * 
 */
package com.designPattern.factory.product;

/**
 * @author 
 *
 */
public class ConcreteProductB2 extends Product2 {
    String brand;

    public ConcreteProductB2() {
        System.out.println("ConcreteProductB2 brand " + brand);
    }

    @Override
    void eat() {
        System.out.println("ConcreteProductA2 eat");
    }
}
