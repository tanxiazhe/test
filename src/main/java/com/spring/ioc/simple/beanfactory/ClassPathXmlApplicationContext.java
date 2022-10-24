package com.spring.ioc.simple.beanfactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class ClassPathXmlApplicationContext implements BeanFactory {

    // 容器的核心，用来存放注入的Bean
    private static Map<String, Object> container = new HashMap<String, Object>();

    class ApplicationContextHandler extends DefaultHandler {

        @Override
        public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
            // Using qualified name because we are not using xmlns prefixes here.
            if (qName.equals("bean")) {
                String id = null;
                Object clazz = null;

                // 扫描配置文件中的bean
                for (int i = 0; i < atts.getLength(); i += 2) {
                    String name = atts.getQName(i);
                    String value = atts.getValue(i);
                    // System.out.println("属性： " + name + "=" + value);
                    if ("id".equals(name)) {
                        id = value;
                    }

                    i++;

                    name = atts.getQName(i);
                    value = atts.getValue(i);
                    // System.out.println("属性： " + name + "=" + value);

                    if ("class".equals(name)) {
                        try {
                            clazz = Class.forName(value).newInstance();
                        } catch (InstantiationException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } catch (ClassNotFoundException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }

                    container.put(id, clazz);
                }
            }
        }

    }

    public ClassPathXmlApplicationContext() {

    }

    // 解析xml文件，通过反射将配置的bean放到container中
    public ClassPathXmlApplicationContext(String fileName) throws SAXException, IOException {
        XMLReader parser = XMLReaderFactory.createXMLReader();
        ApplicationContextHandler applicationContextHandler = (new ClassPathXmlApplicationContext()).new ApplicationContextHandler();
        parser.setContentHandler(applicationContextHandler);
        parser.parse(fileName);
    }

    @Override
    public Object getBean(String id) {
        return container.get(id);
    }

}