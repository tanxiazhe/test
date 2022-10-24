package com.test.encryption;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

public class BASE64 {
  public  static byte[] decryptBASE64(String key) throws IOException {
    return (new BASE64Decoder()).decodeBuffer(key);
  }

  public static String encryptBASE64(byte[] key){
    return (new BASE64Encoder()).encodeBuffer(key);
  }

  public static void main(String[] args) {
    String pwd = "123";
    String res = BASE64.encryptBASE64(pwd.getBytes());
    System.out.println(res);

    byte[] src = new byte[0];
    try {
      src = BASE64.decryptBASE64(res);
    } catch (IOException e) {
      e.printStackTrace();
    }

    System.out.println(new String(src));
  }
}
