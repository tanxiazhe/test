/**
 * 
 */
package com.test;

import java.io.InputStream;

import org.jdom2.Document;
import org.jdom2.input.SAXBuilder;

/**
 * @author
 *
 */
public class PathTest {
    public static void main(String[] args) throws Exception {

        InputStream in = PathTest.class.getResourceAsStream("applicationContext.xml");

        // byte b[] = new byte[1024]; // 创建合适文件大小的数组
        // in.read(b); // 读取文件中的内容到b[]数组
        // in.close();
        // System.out.println(new String(b));

        SAXBuilder sb = new SAXBuilder();

        Document doc = sb.build("NewFile.xml");
        in.close();
        System.out.println(doc);

    }

}
