/**
 * 
 */
package com.designPattern.factory.simpleFactoryPattern;

/**
 * @author 
 *
 */
public class Client {
    public static void main(String[] args) {
        Factory.createProduct("A");
        Factory.createProduct("B");
    }
}
