/**
 * 
 */
package com.designPattern.factory.simpleFactoryPattern;

import com.designPattern.factory.product.ConcreteProductA;
import com.designPattern.factory.product.ConcreteProductB;
import com.designPattern.factory.product.Product;

/**
 * @author 
 *
 */
public class Factory {
    static final Product createProduct(String arg) {
        if (arg == "A") {
            return new ConcreteProductA();
        } else if (arg == "B") {
            return new ConcreteProductB();
        }
        return null;
    }

}
