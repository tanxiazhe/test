/**
 * 
 */
package com.designPattern.single;

import java.io.Serializable;

/**
 * @author
 *
 */
// 注解：饿汉，变种）：
public class Single2_2 implements Serializable {
    private static Single2_2 instance = null;

    private Single2_2() {

    }

    static {
        instance = new Single2_2();

    }

    public static Single2_2 getInstance() {
        return instance;
    }

}
