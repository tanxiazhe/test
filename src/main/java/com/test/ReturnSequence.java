package com.test;

public class ReturnSequence {
  public static void main(String[] args) {
    //    System.out.println("=============NoException==================");
    //    System.out.println(NoException());
    //    System.out.println("===============================");
    //    System.out.println("=============WithException==================");
    //    System.out.println(WithException());
    //    System.out.println("===============================");
//    System.out.println("=============WithException2==================");
//    System.out.println(WithException2());
//    System.out.println("===============================");
//    System.out.println("=============WithException3==================");
//    System.out.println(WithException3());
//    System.out.println("===============================");
    System.out.println(NoException());
  }

  public static int NoException() {
    System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
    int i = 10;
    try {
      System.out.println("i in try block is：" + i);
      return --i;
    } catch (Exception e) {
      --i;
      System.out.println("i in catch - form try block is：" + i);
      return --i;
    } finally {
      System.out.println("i in finally - from try or catch block is：" + i);
      --i;
      System.out.println("i in finally - from finally block is：" + i);
      //      return --i;
    }
  }

  public static int WithException() {
    int i = 10;
    try {
      System.out.println("i in try block is：" + i);
      i = i / 0;
      return --i;
    } catch (Exception e) {
      System.out.println("i in catch - form try block is：" + i);
      --i;
      System.out.println("i in catch block is：" + i);
      return --i;
    } finally {
      System.out.println("i in finally - from try or catch block is--" + i);
      --i;
      System.out.println("i in finally block is--" + i);
      //      return --i;
    }
  }

  public static int WithException2() {
    int i = 10;
    try {
      System.out.println("i in try block is：" + i);
      i = i / 0;
      return --i;
    } catch (Exception e) {
      System.out.println("i in catch - form try block is：" + i);
      int j = i / 0;
      return --i;
    } finally {

      System.out.println("i in finally - from try or catch block is：" + i);
      --i;
      --i;
      System.out.println("i in finally block is：" + i);
      return --i;
    }
  }
  public static int WithException3(){
    int i=10;
    try{
      System.out.println("i in try block is："+i);
      i=i/0;
      //return --i;
    }
    catch(Exception e){
      System.out.println("i in catch - form try block is："+i);
      //int j = i/0;
      //return --i;
    }
    finally{

      System.out.println("i in finally - from try or catch block is："+i);
      --i;
      --i;
      System.out.println("i in finally block is："+i);
      //return --i;
    }
    return --i;
  }
}