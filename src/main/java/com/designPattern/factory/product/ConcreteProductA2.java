/**
 * 
 */
package com.designPattern.factory.product;

/**
 * @author 
 *
 */
public class ConcreteProductA2 extends Product2 {
    String price;

    public ConcreteProductA2() {
        System.out.println("ConcreteProductA2 price " + price);
    }

    @Override
    void eat() {
        System.out.println("ConcreteProductA2 eat");
    }
}
