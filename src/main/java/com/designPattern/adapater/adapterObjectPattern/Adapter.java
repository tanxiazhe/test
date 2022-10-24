/**
 * 
 */
package com.designPattern.adapater.adapterObjectPattern;

import com.designPattern.adapater.common.Adaptee;

/**
 * @author 
 *
 */
public class Adapter extends com.designPattern.adapater.adapterObjectPattern.Target {
    private final Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specificRequest();
    }

}
