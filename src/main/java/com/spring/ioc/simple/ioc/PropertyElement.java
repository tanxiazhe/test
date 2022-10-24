package com.spring.ioc.simple.ioc;

public class PropertyElement {
    DataElement dataElement;
    String name;

    public DataElement getDataElement() {
        return dataElement;
    }

    public void setDataElement(DataElement dataElement) {
        this.dataElement = dataElement;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PropertyElement(DataElement dataElement, String name) {
        super();
        this.dataElement = dataElement;
        this.name = name;
    }

}
