package com.test.encryption;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class FileUtils {

  private static final int ZERO = 0;
  private static final int ONE = 1;
  //实验操作路径
  private static String derectory = FileUtils.class.getClassLoader().getResource("").getPath();

  public static void main(String[] args) {
    //key： 加密密钥
    String key = "aaaabbbbccccdddd";
    //ivParameter：AES cbc加密模式的iv向量
    String ivParameter = "AAAABBBBCCCCDDDD";
    try {
      //对自己的学号姓名的加密过程。
      //学号姓名保存在“学号姓名.txt中”
      //将加密结果保存在“encrypt_Id&Name.txt”中
      String fileName1 = "encrypt_Id&Name.txt";
      File file2 = new File(derectory + "学号姓名.txt");
      File encryptFile = encryptfile(file2, key, ivParameter, fileName1);

      //对给出的密文的解密过程。
      //密文保存在“密文.txt”中
      //将解密结果保存在“明文.txt”中
//      File file = new File(derectory + "密文.txt");
      String fileName = "明文.txt";
      decriptfile(encryptFile, key, ivParameter, fileName);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 文件处理方法
   * code为加密或者解密的判断条件
   * file 密文文件
   * key 加密密钥
   * ivParameterm iv向量
   * filename 加解密结果存入的文件名
   */
  public static File doFile(int code, File file, String key, String ivParameterm, String filename)
      throws Exception {
    BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
    byte[] bytIn = new byte[(int) file.length()];
    bis.read(bytIn);
    bis.close();
    // AES加密
    byte[] raw = key.getBytes("ASCII");
    SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
    //    Cipher cipher = Cipher.getInstance("AES/CBC/NOPadding");
    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    IvParameterSpec iv = new IvParameterSpec(ivParameterm.getBytes());
    if (0 == code) {
      cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
    } else if (1 == code) {
      cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
    }
    // 写文件
    byte[] bytOut = cipher.doFinal(bytIn);
    File outfile = new File(derectory + filename);
    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outfile));
    bos.write(bytOut);
    bos.close();

    return outfile;
  }

  //文件加密
  public static File encryptfile(File file, String key, String ivParameter, String filename)
      throws Exception {
    return doFile(ZERO, file, key, ivParameter, filename);
  }

  //文件解密
  public static File decriptfile(File file, String key, String ivParameter, String filename)
      throws Exception {
    return doFile(ONE, file, key, ivParameter, filename);
  }
}
