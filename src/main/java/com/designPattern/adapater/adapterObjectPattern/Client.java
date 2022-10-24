/**
 * 
 */
package com.designPattern.adapater.adapterObjectPattern;

import com.designPattern.adapater.common.Adaptee;

/**
 * @author 
 *
 */
public class Client {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        com.designPattern.adapater.adapterObjectPattern.Target target = new Adapter(adaptee);
        target.request();
    }

}
