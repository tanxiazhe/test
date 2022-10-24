package com.test.encryption;


import java.security.NoSuchAlgorithmException;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class HMAC {
  public static final String HMAC="HMAC";

  public static String initMacKey() throws NoSuchAlgorithmException {
    KeyGenerator keyGenerator = KeyGenerator.getInstance(HMAC);
    SecretKey secretKey = keyGenerator.generateKey();
    return BASE64.encryptBASE64(secretKey.getEncoded());
  }

  public static String encryptHMAC(byte[] data, String key) throws Exception {
    SecretKey secretKey = new SecretKeySpec(BASE64.decryptBASE64(key),HMAC);
    Mac mac = Mac.getInstance(secretKey.getAlgorithm());
    mac.init(secretKey);
    return new String(mac.doFinal(data));

  }


}
