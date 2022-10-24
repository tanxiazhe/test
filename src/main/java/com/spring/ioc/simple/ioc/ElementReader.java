package com.spring.ioc.simple.ioc;

import java.util.List;

import org.dom4j.Element;

/**
 * 解析Element元素
 * 
 * @author Yiron
 *
 */
public interface ElementReader {

    boolean isLazy(Element element);

    List<Element> getConstructorElements(Element element);

    String getAttribute(Element element, String name);

    boolean isSingleTon(Element element);

    List<Element> getPropertyElements(Element element);

    AutoWire getAutoWire(Element element);

    List<DataElement> getConstructorValue(Element element);

    List<PropertyElement> getPropertyValue(Element element);

}