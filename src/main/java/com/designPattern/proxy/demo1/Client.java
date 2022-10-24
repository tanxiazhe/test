/**
 * 
 */
package com.designPattern.proxy.demo1;

/**
 * @author 
 *
 */
public class Client {
    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.preRequest();
        proxy.request();
        proxy.afterRequest();
    }

}
