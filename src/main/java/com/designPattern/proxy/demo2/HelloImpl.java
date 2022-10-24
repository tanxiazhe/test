/**
 * 
 */
package com.designPattern.proxy.demo2;

/**
 * @author 
 *
 */
public class HelloImpl implements Hello {

    @Override
    public void say(String name) {
        System.out.println("hello " + name);
    }

}
