/**
 * 
 */
package com.designPattern.adapater.adapterClassPattern;

import com.designPattern.adapater.common.Adaptee;

/**
 * @author 
 *
 */
public class Adapter extends Adaptee implements com.designPattern.adapater.adapterClassPattern.Target {

    @Override
    public void request() {
        specificRequest();
    }

}
