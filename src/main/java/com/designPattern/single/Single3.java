/**
 * 
 */
package com.designPattern.single;

/**
 * @author
 *
 */
// 注解：定义一个私有的静态内部类，在第一次用这个嵌套类时，会创建一个实例。
// 而类型为SingletonHolder的类，只有在Singleton.getInstance()中调用，
// 由于私有的属性，他人无法使用SingleHolder，不调用Singleton.getInstance()就不会创建实例。
// 优点：达到了lazy loading的效果，即按需创建实例。(good)
public class Single3 {

    private Single3() {

    }

    private static class SingleHolder {
        private static final Single3 instance = new Single3();

    }

    public static final Single3 getInstance() {
        return SingleHolder.instance;
    }

}
