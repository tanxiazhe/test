package com.test.encryption;

import org.apache.commons.io.IOUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESUtils {
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

  public static InputStream encrypt(InputStream inputStream) throws Exception {
    SecretKeySpec secretKeySpec = getKey(KEY);
    IvParameterSpec ivParameterSpec = new IvParameterSpec(IV.getBytes());
    Cipher cipher = Cipher.getInstance(TRANSFORMATION);
    cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);

    byte[] res = cipher.doFinal(IOUtils.toByteArray(inputStream));
//    String encodeString = base64Encode(res);
//    System.out.println("encode"+encodeString);
    return new ByteArrayInputStream(res);
  }

  public static InputStream decrypt(InputStream inputStream) throws Exception {
    SecretKeySpec secretKeySpec = getKey(KEY);
    IvParameterSpec ivParameterSpec = new IvParameterSpec(IV.getBytes());
    Cipher cipher = Cipher.getInstance(TRANSFORMATION);
    cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
    byte[] is = IOUtils.toByteArray(inputStream);
//    byte[] temp = base64Decode(new String(is));
//    System.out.println("decode  "+new String(temp));
    byte[] res = cipher.doFinal(is);
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
//    System.out.println("加密：" + IOUtils.toString(bis, "UTF-8"));

    InputStream encrypt = encrypt(bis);
//    System.out.println("加密后：" + IOUtils.toString(encrypt, "UTF-8"));

    InputStream decrypt = decrypt(encrypt);
    System.out.println("解密后：" + IOUtils.toString(decrypt, "UTF-8"));
  }
}
