/**
 * 
 */
package com.spring.ioc.springBeanTest;

/**
 * @author 
 *
 */
public class OtherBean1 {
    private String name;

    public OtherBean1() {
        System.out.println("【构造器】调用OtherBean1的构造器实例化");
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        System.out.println("OtherBean1【注入属性】注入属性name");
        this.name = name;
    }

    @Override
    public String toString() {
        return "OtherBean1[name=" + name + "]";
    }

}
