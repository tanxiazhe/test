/**
 * 
 */
package com.designPattern.single;

/**
 * @author
 *
 */

// 注解：初试化静态的instance创建一次。如果我们在Singleton类里面写一个静态的方法不需要创建实例，它仍然会早早的创建一次实例。而降低内存的使用率。
// 缺点：没有lazy loading的效果，从而降低内存的使用率。(good)
public class Single2 {
    private static Single2 instance = new Single2();

    private Single2() {

    }

    // 饿汉模式
    public static Single2 getInstance() {
        return instance;
    }

}
