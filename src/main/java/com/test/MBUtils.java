package com.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class MBUtils {
  public static void main(String[] args) throws IOException {
    //    Scanner scanner=new Scanner(System.in);
    //    while(scanner.hasNext()) {
    //      String str = scanner.next();
    //      BigInteger num = new BigInteger(str);
    //      BigInteger div = new BigInteger("1048576");
    //      System.out.println(num.divide(div) + "M");
    //    }

//    char[] t = new char[26];
//    t['a' - 'a'] = 10;
//    t['b'] = 8;
//    t['c'] = 2;
//    Arrays.sort(t);
//    System.out.println(t);
//    char[] a = new char[4];
//    char[] b = new char[5];
//    char[] c = new char[8];
//    char[] d = new char[200];
//    String s = a.toString();
//    s.substring(0,i)
//    Map<Long, Long> hashMap = new HashMap<>();
//    Map<String, Object> hashMap = new HashMap<String, Object>();
//    Set<Map.Entry<String, Object>> its = hashMap.entrySet();
//    for (Map.Entry<String, Object> it : its) {
//      String key = it.getKey();
//      Object value = it.getValue();
//      try {
//        Long l = Long.parseLong(key);
//      } catch (NumberFormatException e) {
//        continue;
//      }
//    }

    System.out.println(solution(1,1, 6));
  }
  public static String solution(int A, int B, int C) {
    // write your code in Java SE 8
    char[] res = new char[A+B+C];
    String str = null;

    char[] a = new char[A];
    char[] b = new char[B];
    char[] c = new char[C];

    int k=0;
    for(int i=0; i< A; i++){
      a[k++]='a';
    }
    k=0;
    for(int j=0; j<B; j++){
      b[k++]='b';
    }
    k=0;
    for(int l = 0; l<C;l++){
      c[k++]='c';
    }
    String as=null, bs=null, cs=null;
    if(A <3 && B < 3 && C < 3){
      as = a.toString();
      bs= b.toString();
      cs = c.toString();
      str = as+bs+cs;
      return str;
    }

    if( A < 3 && B < 3 && C >3 ){
      int i=0;
      int j=0, l=0;
      for(; i< C; i++){
        if(i%3 ==2){
          System.out.println(i);
          if(j < B){
            c[i] = 'b';
            b[j] = 'c';
            j=j+2;
          }
          if(l < A){
            c[i] = 'a';
            a[l] = 'c';
            l=l+2;
          }

        }
      }

      as =  new String(a);
      bs= new String(b);
      cs = new String(c);
      System.out.println("as->"+ as );
      System.out.println("bs->"+ bs);
      System.out.println("cs->"+ cs);
      System.out.println(i+ " ->"+cs.substring(0,i));
      str = cs.substring(0,i-1)+as+bs;
      return str;
    }

    if(A < B && B < C){
      for(int i=1; i< C; i++){
        if(i%3 == 2){
          if(i < B){
            c[i] = 'b';
            b[i] = 'c';
          }
          if(i-B < A){
            c[i] = 'a';
            a[i] = 'c';
          }

        }
      }

      as = a.toString();
      bs= b.toString();
      cs = c.toString();
      str = as+bs+cs;
      return str;
    }

    return str;

  }
  class UserStats {
    public Optional<Long> getVisitCount() {
      return visitCount;
    }

    private  Optional<Long> visitCount;

    public void setVisitCount(Optional<Long> visitCount) {
      this.visitCount = visitCount;
    }

  }

  Map<Long, Long> count(Map<String, UserStats>... visits) {
    if(visits.length == 0){
      return null;
    }
    Map<Long, Long> hashMap = new HashMap<>();

    for(int i=0; i< visits.length; i++){
      Map<String, UserStats> temp = visits[i];

      Set<Map.Entry<String, UserStats>> its = temp.entrySet();
      for (Map.Entry<String, UserStats> it : its) {
        String key = it.getKey();
        UserStats value = it.getValue();
        try {
          Long l = Long.parseLong(key);
          if (value==null) {
            continue;
          } else {
            Optional<Long> v = value.getVisitCount();
            Optional<Long> EMPTY = Optional.empty();
            if (v.equals(EMPTY) || !v.isPresent()) {
              continue;
            } else {
              if(hashMap.containsKey(l)) {
                hashMap.put(l, v.get()+ hashMap.get(l));
              }else{
                hashMap.put(l, v.get());
              }
            }
          }
        } catch (NumberFormatException e) {
          continue;
        }

      }
    }


    return hashMap;
  }
}
