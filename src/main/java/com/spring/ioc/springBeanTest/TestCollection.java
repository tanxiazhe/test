package com.spring.ioc.springBeanTest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class TestCollection {
    private List<String> listTest;
    private Map<String, Object> mapTest;
    private Set<Object> setTest;
    private Object[] arrayTest;
    private Properties propertiesTest;

    public TestCollection() {
        System.out.println("【构造器】调用TestCollection的构造器实例化");
    }

    public List<String> getListTest() {
        return listTest;
    }

    public void setListTest(List<String> listTest) {
        System.out.println("TestCollection【注入属性】注入属性listTest");
        this.listTest = listTest;
    }

    public Map<String, Object> getMapTest() {
        return mapTest;
    }

    public void setMapTest(Map<String, Object> mapTest) {
        System.out.println("TestCollection【注入属性】注入属性mapTest");
        this.mapTest = mapTest;
    }

    public Set<Object> getSetTest() {
        return setTest;
    }

    public void setSetTest(Set<Object> setTest) {
        System.out.println("TestCollection【注入属性】注入属性setTest");
        this.setTest = setTest;
    }

    public Object[] getArrayTest() {
        return arrayTest;
    }

    public void setArrayTest(Object[] arrayTest) {
        System.out.println("TestCollection【注入属性】注入属性arrayTest");
        this.arrayTest = arrayTest;
    }

    public Properties getPropertiesTest() {
        return propertiesTest;
    }

    public void setPropertiesTest(Properties propertiesTest) {
        System.out.println("TestCollection【注入属性】注入属性propertiesTest");
        this.propertiesTest = propertiesTest;
    }

    @Override
    public String toString() {
        return "TestCollection \n [listTest=" + listTest + ",\n mapTest=" + mapTest + ",\n setTest=" + setTest
                + ",\n arrayTest=" + Arrays.toString(arrayTest) + ",\n propertiesTest=" + propertiesTest + "]";
    }

}