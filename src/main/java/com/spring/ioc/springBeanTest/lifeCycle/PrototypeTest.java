/**
 * 
 */
package com.spring.ioc.springBeanTest.lifeCycle;

/**
 * @author 
 *
 */
public class PrototypeTest {
    private String name;
    private Long id;

    public PrototypeTest() {
        System.out.println("默认构造器注入方式");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("【注入属性】注入属性name");
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        System.out.println("【注入属性】注入属性id");
        this.id = id;
    }

}
