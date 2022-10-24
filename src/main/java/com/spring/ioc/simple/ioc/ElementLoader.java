package com.spring.ioc.simple.ioc;

import java.util.Collection;

import org.dom4j.Document;
import org.dom4j.Element;

/**
 * 加载Element元素
 * 
 * @author Yiron
 *
 */
public interface ElementLoader {

    void addElements(Document doc);// 添加元素

    Element getElement(String id);// 获取元素

    Collection<Element> getElements();// 获取所有的元素

}