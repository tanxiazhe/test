//工厂接口  
package com.spring.ioc.simple.beanfactory;

public interface BeanFactory {
    Object getBean(String id);
}
