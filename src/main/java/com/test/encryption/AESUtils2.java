package com.test.encryption;

import org.apache.commons.io.IOUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESUtils2 {
  private static final String ALGORITHM = "AES";
  public static final String TRANSFORMATION = "AES/CBC/PKCS5PAdding";
  public static final String IV = "1234567812345678";
  public static final String KEY = "aaaabbbbccccddddaaaabbbbccccdddd";
  public static final int KEY_SIZE = 256;

  public static String base64Encode(byte[] bytes) {
    return new BASE64Encoder().encode(bytes);
  }

  public static byte[] base64Decode(String base64Code) throws IOException {
    return base64Code.isEmpty() ? null : new BASE64Decoder().decodeBuffer(base64Code);
  }

  public static String aesEncrypt(File file)
      throws NoSuchPaddingException, InvalidKeyException, NoSuchAlgorithmException, IOException,
             BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
    return base64Encode(encrypt(file));
  }

  public static String aesDecrypt(String encryptString)
      throws IOException, NoSuchPaddingException, InvalidKeyException, NoSuchAlgorithmException,
             IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
    return encryptString.isEmpty() ? null : decrypt(base64Decode(encryptString));
  }

  private static byte[] encrypt(File file)
      throws NoSuchPaddingException, NoSuchAlgorithmException, IOException, BadPaddingException,
             IllegalBlockSizeException, InvalidAlgorithmParameterException, InvalidKeyException {
    SecretKeySpec secretKeySpec = getKey(KEY);
    IvParameterSpec ivParameterSpec = new IvParameterSpec(IV.getBytes());
    Cipher cipher = Cipher.getInstance(TRANSFORMATION);
    cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);

    byte[] res =
        cipher.doFinal(IOUtils.toByteArray(new BufferedInputStream(new FileInputStream(file))));
    return res;
  }

  private static String decrypt(byte[] base64Decode)
      throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException,
             InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException,
             IllegalBlockSizeException {
    SecretKeySpec secretKeySpec = getKey(KEY);
    IvParameterSpec ivParameterSpec = new IvParameterSpec(IV.getBytes());
    Cipher cipher = Cipher.getInstance(TRANSFORMATION);
    cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
    byte[] res = cipher.doFinal(base64Decode);
    return new String(res);
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

  public static void main(String[] args)
      throws NoSuchPaddingException, InvalidAlgorithmParameterException, NoSuchAlgorithmException,
             IOException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException {
    String path = AESUtils2.class.getClassLoader().getResource("").getPath();

    File file = new File(path + "学号姓名.txt");
    String encrypt = aesEncrypt(file);
    System.out.println("加密后：" + encrypt);

    String decrypt = aesDecrypt(encrypt);
    System.out.println("解密后：" + decrypt);
  }
}
