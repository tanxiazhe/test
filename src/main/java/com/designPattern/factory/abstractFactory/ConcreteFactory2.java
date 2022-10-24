/**
 * 
 */
package com.designPattern.factory.abstractFactory;

import com.designPattern.factory.product.ConcreteProductA2;
import com.designPattern.factory.product.ConcreteProductB2;

/**
 * @author 
 *
 */
public class ConcreteFactory2 extends AbstractFactory {

    @Override
    void createProductA() {
        new ConcreteProductA2();
    }

    @Override
    void createProductB() {
        new ConcreteProductB2();
    }

}
