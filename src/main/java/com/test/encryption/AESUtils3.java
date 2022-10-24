package com.test.encryption;

import org.apache.commons.io.IOUtils;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESUtils3 {
  private static final String ALGORITHM = "AES";
  public static final String TRANSFORMATION = "AES/CBC/PKCS5PAdding";
  public static final String IV = "1234567812345678";
  public static final String KEY = "aaaabbbbccccddddaaaabbbbccccdddd";
  public static final int KEY_SIZE = 256;

  public static InputStream encrypt(InputStream inputStream) throws Exception {
    return encryptOrDecrypt(inputStream, Cipher.ENCRYPT_MODE);
  }

  public static InputStream decrypt(InputStream inputStream) throws Exception {
    return encryptOrDecrypt(inputStream, Cipher.DECRYPT_MODE);
  }

  private static InputStream encryptOrDecrypt(InputStream inputStream, int mode) throws Exception {
    SecretKeySpec secretKeySpec = getKey(KEY);
    IvParameterSpec ivParameterSpec = new IvParameterSpec(IV.getBytes());
    Cipher cipher = Cipher.getInstance(TRANSFORMATION);
    cipher.init(mode, secretKeySpec, ivParameterSpec);
    byte[] res = cipher.doFinal(IOUtils.toByteArray(inputStream));
    return new ByteArrayInputStream(res);
  }

  private static SecretKeySpec getKey(String seed)
      throws UnsupportedEncodingException, NoSuchAlgorithmException {
    KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
    SecureRandom secureRandom;
    if (seed != null && !"".equals(seed)) {
      secureRandom = new SecureRandom(seed.getBytes("ASCII"));
    } else {
      secureRandom = new SecureRandom();
    }

    keyGenerator.init(KEY_SIZE, secureRandom);
    SecretKey secretKey = keyGenerator.generateKey();
    return new SecretKeySpec(secretKey.getEncoded(), ALGORITHM);
  }

  public static void main(String[] args) throws Exception {
    String path = AESUtils2.class.getClassLoader().getResource("").getPath();

    File file = new File(path + "学号姓名.txt");
    BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
    System.out.println("加密：" + bis);

    InputStream encrypt = encryptOrDecrypt(bis,1);
    System.out.println("加密后：" + encrypt);

    InputStream  decrypt = encryptOrDecrypt(encrypt,2);
    System.out.println("解密后：" + decrypt);
  }
}
