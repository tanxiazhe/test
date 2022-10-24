package com.spring.ioc;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;

import com.spring.ioc.springBeanTest.lifeCycle.Person;

public class TestDefaultListableBeanFactory {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(beanFactory);
        reader.register(Person.class);
        System.out.println(beanFactory.getBean(Person.class));
    }

}
