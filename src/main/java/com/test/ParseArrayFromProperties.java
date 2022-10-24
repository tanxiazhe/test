package com.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ParseArrayFromProperties {
    public static void main(String[] args) {
        InputStream in = ParseArrayFromProperties.class.getClassLoader().getResourceAsStream("test.properties");

        Properties pro = new Properties();

        try {
            pro.load(in);

            String  key = pro.getProperty("key").trim();

            String[] arr = key.split(",");
            for(String i : arr){
                System.out.println(i);
            }

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
