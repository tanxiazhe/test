/**
 * 
 */
package com.designPattern.proxy.demo1;

/**
 * @author 
 *
 */
public class Proxy extends Subject {
    RealSubject realSubject = new RealSubject();

    void preRequest() {
        System.out.println("Proxy pre request.");
    }

    @Override
    void request() {
        realSubject.request();
    }

    void afterRequest() {
        System.out.println("Proxy after request.");
    }

}
