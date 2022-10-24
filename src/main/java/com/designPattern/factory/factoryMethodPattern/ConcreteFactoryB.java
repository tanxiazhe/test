/**
 * 
 */
package com.designPattern.factory.factoryMethodPattern;

import com.designPattern.factory.product.ConcreteProductB;
import com.designPattern.factory.product.Product;

/**
 * @author 
 *
 */
public class ConcreteFactoryB extends Factory {

    @Override
    Product createProduct() {
        return new ConcreteProductB();
    }

}
