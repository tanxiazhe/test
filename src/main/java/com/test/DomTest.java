package com.test;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomTest {

    public static void main(String[] args) {

        // （1）创建DocumentBuilderFactory对象

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {

            // （2）创建DocumentBuilder对象

            DocumentBuilder db = dbf.newDocumentBuilder();

            // （3）通过DocumentBuilder对象的parse方法加载book.xml

            Document document = db.parse("books.xml");

            // 解析xml文件属性
            // （1）获取所有book节点的集合

            NodeList booklist = document.getElementsByTagName("book");

            System.out.println("共有" + booklist.getLength() + "本书");

            System.out.println("-------------------------------------");

            // （2）遍历每个book节点

            for (int i = 0; i < booklist.getLength(); i++) {

                // （3）通过item(i)获取book节点，nodelist索引从0开始

                Node book = booklist.item(i);

                // （4）获取book节点的所有属性集合

                NamedNodeMap attrs = book.getAttributes();

                // 获取属性的数量

                System.out.println("第" + (i + 1) + "本书有" + attrs.getLength() + "个属性");

                System.out.print("分别是：");

                // （5）遍历book的属性

                for (int j = 0; j < attrs.getLength(); j++) {

                    // （6）获取属性

                    Node att = attrs.item(j);

                    // （6）获取属性的名称

                    String attName = att.getNodeName();

                    System.out.print(attName + ", ");

                }

                System.out.println();

                System.out.println("子节点：");

                // （1）解析book节点的子节点

                NodeList bookChildNodes = book.getChildNodes();

                // （2）遍历bookChildNodes获取每个子节点

                for (int k = 0; k < bookChildNodes.getLength(); k++) {

                    // （3）获取子节点

                    Node bookChild = bookChildNodes.item(k);

                    // 注(a)

                    // 区分text类型的node以及element类型的node（子节点含我们不需要的文本型，所以我们要筛选）

                    if (bookChild.getNodeType() == Node.ELEMENT_NODE) {

                        // 注（b）

                        // （4）获取和输出节点名和节点内容

                        // 方法1：

                        System.out.println(bookChild.getNodeName() + ",  " + bookChild.getNodeValue());

                        // 方法2：

                        // System.out.println(bookChild.getNodeName() + ", " +
                        // bookChild.getFirstChild().getNodeValue());

                    }

                }
                System.out.println("-------------------------------------");
            }

        } catch (ParserConfigurationException e) {

            e.printStackTrace();

        } catch (SAXException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();
        }

    }

}