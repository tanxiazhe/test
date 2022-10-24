/**
 * 
 */
package com.test;

/**
 * @author 
 *
 */

import java.io.FileOutputStream;
import java.io.IOException;

class Test1 {
    public static void main(String[] args) {
        FileOutputStream fOut;
        try {
            fOut = new FileOutputStream("c:\\Test1.txt");
            fOut.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("被调用成功!");
    }
}

public class Test_Exec {
    public static void main(String[] args) {
        Runtime run = Runtime.getRuntime();
        try {
            Process p = run.exec("java Test_Exec");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
