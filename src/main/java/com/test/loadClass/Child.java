package com.test.loadClass;

public class Child extends Parent {
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

  public Child() {
    System.out.println("--->constructor--->" + Child.class.getSimpleName());
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
    System.out.println("--->static " + type + " " + value + "--->" + Child.class.getSimpleName());
    return 0;
  }

  private int print(String type, int value) {
    System.out.println("--->" + type + " " + value + "--->" + Child.class.getSimpleName());
    return 0;
  }

  public static void main(String[] args) {
    Child c = new Child();
  }
}