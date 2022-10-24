/**
 * 
 */
package com.designPattern.factory.factoryMethodPattern;

import com.designPattern.factory.product.ConcreteProductA;
import com.designPattern.factory.product.Product;

/**
 * @author 
 *
 */
public class ConcreteFactoryA extends Factory {

    @Override
    Product createProduct() {
        return new ConcreteProductA();
    }

}
