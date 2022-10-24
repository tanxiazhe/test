package com.test.encryption;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
public static final String MD5 = "MD5";
  public  static  String encrypt(String data) throws NoSuchAlgorithmException {
    MessageDigest messageDigest = MessageDigest.getInstance(MD5);
    byte[] inputData = data.getBytes();
    messageDigest.update(inputData);
    BigInteger bigInteger ;
    bigInteger = new BigInteger(messageDigest.digest());
    return bigInteger.toString(16);

  }

  public static void main(String[] args) {
    String input = "gaghh";
    try {
      System.out.println(encrypt(input));
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
  }
}
