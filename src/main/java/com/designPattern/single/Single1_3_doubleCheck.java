/**
 * 
 */
package com.designPattern.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 双重检验锁
 *
 */
// 注解：只有当instance为null时，需要获取同步锁，创建一次实例。当实例被创建，则无需试图加锁。
// 缺点：用双重if判断，复杂，容易出错。(ok)
public class Single1_3_doubleCheck implements Serializable {
    private static Single1_3_doubleCheck instance = null;

    private Single1_3_doubleCheck() {

    }

    public static Single1_3_doubleCheck getInstance() {

        if (instance == null) {
            synchronized (Single1_3_doubleCheck.class) {
                if (instance == null) {
                    instance = new Single1_3_doubleCheck();
                }
            }

        }
        return instance;
    }

    private Object readResolve() {
        return instance;
    }

    // 为了便于理解，忽略关闭流操作及删除文件操作。真正编码时千万不要忘记
    // Exception直接抛出
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Write Obj to file
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tempFile"));
        oos.writeObject(Single1_3_doubleCheck.getInstance());
        // Read Obj from file
        File file = new File("tempFile");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Single1_3_doubleCheck newInstance = (Single1_3_doubleCheck) ois.readObject();
        // 判断是否是同一个对象
        System.out.println(newInstance == Single1_3_doubleCheck.getInstance());
    }

}
