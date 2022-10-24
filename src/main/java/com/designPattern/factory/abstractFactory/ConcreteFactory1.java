/**
 * 
 */
package com.designPattern.factory.abstractFactory;

import com.designPattern.factory.product.ConcreteProductA;
import com.designPattern.factory.product.ConcreteProductB;

/**
 * @author 
 *
 */
public class ConcreteFactory1 extends AbstractFactory {

    @Override
    void createProductA() {
        new ConcreteProductA();
    }

    @Override
    void createProductB() {
        new ConcreteProductB();
    }

}
