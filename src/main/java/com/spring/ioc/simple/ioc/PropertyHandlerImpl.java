package com.spring.ioc.simple.ioc;

import java.lang.reflect.Method;
import java.util.Map;

public class PropertyHandlerImpl implements PropertyHandler {

    @Override
    public void setProperties(Object obj, Map<String, Object> propertiesMap) {

    }

    @Override
    public void executeMethod(Object obj, Object bean, Method method) {

    }

    @Override
    public Map<String, Method> getSetterMethodsMap(Object obj) {
        return null;
    }

}
