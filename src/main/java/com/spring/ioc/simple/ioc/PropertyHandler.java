package com.spring.ioc.simple.ioc;

import java.lang.reflect.Method;
import java.util.Map;

public interface PropertyHandler {

    void setProperties(Object obj, Map<String, Object> propertiesMap);

    void executeMethod(Object obj, Object bean, Method method);

    Map<String, Method> getSetterMethodsMap(Object obj);

}
