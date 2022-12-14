package com.spring.ioc.springBeanTest.lifeCycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author qsk
 */
public class Person implements BeanNameAware,
    BeanFactoryAware,
    ApplicationContextAware,
    InitializingBean,
    DisposableBean {

  private String name;
  private String address;
  private int phone;

  private String beanName;
  private BeanFactory beanFactory;
  private ApplicationContext applicationContext;

  public Person() {
    System.out.println("【构造器】调用Person的构造器实例化");
  }

  public Person(String name, String address, int phone) {
    super();
    this.name = name;
    this.address = address;
    this.phone = phone;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    System.out.println("【注入属性】注入属性name");
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    System.out.println("【注入属性】注入属性address");
    this.address = address;
  }

  public int getPhone() {
    return phone;
  }

  public void setPhone(int phone) {
    System.out.println("【注入属性】注入属性phone");
    this.phone = phone;
  }

  @Override
  public String toString() {
    return "Person [address=" + address + ", name=" + name + ", phone=" + phone + "]";
  }

  // 这是BeanNameAware接口方法
  @Override
  public void setBeanName(String arg0) {
    System.out.println("【BeanNameAware接口】调用BeanNameAware.setBeanName()");
    this.beanName = arg0;
  }

  // 这是BeanFactoryAware接口方法
  @Override
  public void setBeanFactory(BeanFactory arg0) throws BeansException {
    System.out.println("【BeanFactoryAware接口】调用BeanFactoryAware.setBeanFactory()");
    this.beanFactory = arg0;
  }

  // 这是ApplicationContext接口方法
  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.applicationContext = applicationContext;
    System.out.println("【ApplicationContextAware】 调用setApplicationContext方法" + applicationContext);
  }

  // 这是InitializingBean接口方法
  @Override
  public void afterPropertiesSet() throws Exception {
    System.out.println("【InitializingBean接口】调用InitializingBean.afterPropertiesSet()");
  }

  // 通过<bean>的init-method属性指定的初始化方法
  public void myInit() {
    System.out.println("【init-method】调用<bean>的init-method属性指定的初始化方法");
  }

  // 这是DiposibleBean接口方法
  @Override
  public void destroy() throws Exception {
    System.out.println("【DiposibleBean接口】调用DiposibleBean.destory()");
  }

  // 通过<bean>的destroy-method属性指定的初始化方法
  public void myDestory() {
    System.out.println("【destroy-method】调用<bean>的destroy-method属性指定的初始化方法");
  }
}