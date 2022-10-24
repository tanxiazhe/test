package com.test.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Title:
 *
 * @Author
 * @CreateTime 2019/6/12 15:31
 */
public class Leetcode_93_RestoreIPAddresses {

  /**
   * 使用穷举法
   *
   * @param s
   * @return
   */
  public List<String> restoreIpAddresses(String s) {
    List<String> res = new ArrayList<>();
    int len = s.length();
    StringBuilder sb = new StringBuilder();
    int sub1, sub2, sub3, sub4;
    for (int h = 1; h <= 3; h++) {
      for (int i = 1; i <= 3; i++) {
        for (int j = 1; j <= 3; j++) {
          for (int k = 1; k <= 3; k++) {
            if (h + i + j + k == len) {
              sub1 = Integer.parseInt(s.substring(0, h));
              sub2 = Integer.parseInt(s.substring(h, h + i));
              sub3 = Integer.parseInt(s.substring(h + i, h + i + j));
              sub4 = Integer.parseInt(s.substring(h + i + j, h + i + j + k));
              //如果s.substring(0, h)=010,但是sub1=10,少了一位则报错，所以需要转换前后的位数相等
              if (String.valueOf(sub1).length() == h && String.valueOf(sub2).length() == i
                  && String.valueOf(sub3).length() == j && String.valueOf(sub4).length() == k
                  && sub1 <= 255 && sub2 <= 255 && sub3 <= 255 && sub4 <= 255) {
                sb.append(sub1).append(".").append(sub2).append(".").append(sub3).append(".")
                    .append(sub4);
                res.add(sb.toString());
                sb.delete(0, sb.length());
              }
            }
          }
        }
      }
    }
    return res;
  }

  public static void main(String[] args) {
    Leetcode_93_RestoreIPAddresses object = new Leetcode_93_RestoreIPAddresses();
    //        System.out.println(object.restoreIpAddresses("12345678"));//[1.234.56.78, 12.34.56
      //        .78, 123.4.56.78, 123.45.6.78, 123.45.67.8]
    System.out.println(object.restoreIpAddresses("010010"));//[0.10.0.10, 0.100.1.0]
  }
}
