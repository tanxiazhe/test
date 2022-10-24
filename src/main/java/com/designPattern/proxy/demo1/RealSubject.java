/**
 * 
 */
package com.designPattern.proxy.demo1;

/**
 * @author 
 *
 */
public class RealSubject extends Subject {

    @Override
    void request() {
        System.out.println("Real subject send request.");
    }

}
