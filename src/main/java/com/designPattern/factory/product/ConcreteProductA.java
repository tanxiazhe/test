/**
 * 
 */
package com.designPattern.factory.product;

/**
 * @author 
 *
 */
public class ConcreteProductA extends Product {
    String price;

    public ConcreteProductA() {
        System.out.println("ConcreteProductA price " + price);
    }
}
