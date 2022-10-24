/**
 * 
 */
package com.designPattern.adapater.adapterClassPattern;

/**
 * @author 
 *
 */
public class Client {
    public static void main(String[] args) {
        com.designPattern.adapater.adapterClassPattern.Target target = new Adapter();
        target.request();
    }

}
