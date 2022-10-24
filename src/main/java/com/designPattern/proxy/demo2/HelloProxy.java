/**
 * 
 */
package com.designPattern.proxy.demo2;

/**
 * @author 
 *
 */
public class HelloProxy implements Hello {

    private final Hello hello;

    public HelloProxy() {
        hello = new HelloImpl();
    }

    @Override
    public void say(String name) {
        before();
        hello.say(name);
        after();
    }

    /**
     * 
     */
    private void before() {
        System.out.println("Before");
    }

    /**
     * 
     */
    private void after() {
        System.out.println("after");
    }

    public static void main(String[] args) {
        Hello helloProxy = new HelloProxy();
        helloProxy.say("java");
    }

}
