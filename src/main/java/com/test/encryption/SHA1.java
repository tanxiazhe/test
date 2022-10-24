package com.test.encryption;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA1 {
  public static final String SHA1 = "SHA256";

  public static String encrypt(String data) throws NoSuchAlgorithmException {
    MessageDigest messageDigest = MessageDigest.getInstance(SHA1);
    byte[] inputData = data.getBytes();
    messageDigest.update(inputData);
    BigInteger bigInteger;

    bigInteger = new BigInteger(messageDigest.digest());
    return bigInteger.toString();
  }

  public static void main(String[] args) {
    String input = "gggggg";
    try {
      System.out.println(encrypt(input));
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
  }
}
