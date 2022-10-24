/**
 * 
 */
package com.spring.ioc.springBeanTest.lifeCycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 
 *
 */

@Component
public class TestAutoWired {
    String name;

    @Autowired
    private Person person;

    @Override
    public String toString() {
        return "Address: " + person.getAddress();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
