/**
 * 
 */
package com.spring.ioc.springBeanTest;

/**
 * @author 
 *
 */
public class OtherBean2 {
    private String name;
    private int id;

    public OtherBean2() {
        System.out.println("【构造器】调用OtherBean2的构造器实例化");
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
        System.out.println("OtherBean2【注入属性】注入属性name");
        this.name = name;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(int id) {
        System.out.println("OtherBean2【注入属性】注入属性id");
        this.id = id;
    }

    @Override
    public String toString() {
        return "OtherBean2[name=" + name + ", id=" + id + "]";
    }

}
