package com.test.loadClass;

/**
 * 1.1 没有父类的情况
 * 静态变量/代码块（优先级一样，看谁在前面）
 * 实例变量/代码块（优先级一样，看谁在前面）
 * 构造方法
 * 1.2 有父类的情况
 * 父类静态变量/代码块（优先级一样，看谁在前面）
 * 子类静态变量/代码块（优先级一样，看谁在前面）
 * 父类实例变量/代码块（优先级一样，看谁在前面）
 * 父类构造方法
 * 子类实例变量/代码块（优先级一样，看谁在前面）
 * 子类构造方法
 * 1.3 内部类加载
 * 内部类也是类，仅在使用的时候加载
 */
public class Parent {
  private static int staticVar1 = staticPrint("var", 1);

  static {
    staticPrint("code", 1);
  }

  private static int staticVar2 = staticPrint("var", 2);

  static {
    staticPrint("code", 2);
  }

  private int var1 = print("var", 1);

  {
    print("code", 1);
  }

  private int var2 = print("var", 2);

  {
    print("code", 2);
  }

  public Parent() {
    System.out.println("--->constructor--->" + Parent.class.getSimpleName());
  }

  private class InnnerA {
    public InnnerA() {
      System.out.println("----innerA");
    }
  }

  private static class InnnerB {
    public InnnerB() {
      System.out.println("----innerB");
    }
  }

  private static int staticVar3 = staticPrint("var", 3);

  static {
    staticPrint("code", 3);
  }

  private static int staticVar4 = staticPrint("var", 4);

  static {
    staticPrint("code", 4);
  }

  private int var3 = print("var", 3);

  {
    print("code", 3);
  }

  private int var4 = print("var", 4);

  {
    print("code", 4);
  }


  private static int staticPrint(String type, int value) {
    System.out.println("--->static " + type + " " + value + "--->" + Parent.class.getSimpleName());
    return 0;
  }

  private int print(String type, int value) {
    System.out.println("--->" + type + " " + value + "--->" + Parent.class.getSimpleName());
    return 0;
  }

  private void innerA() {
    InnnerA innnerA = new InnnerA();
  }

  private static void innerB() {
    InnnerB innnerB = new InnnerB();
  }

  public static void main(String[] args) {
    Parent p = new Parent();
    p.innerA();
  }
}