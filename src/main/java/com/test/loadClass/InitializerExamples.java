package com.test.loadClass;

public class InitializerExamples {
  static int count;
  int i;


  {  //This is an instance initializers. Run every time an object is created.
    //static and instance variables can be accessed
    System.out.println("\nInstance Initializer");
    i = 6;
    count = count + 1;
    System.out.println("Count when Instance Initializer is run is " + count);
  }

  static {//This is a static initializers. Run only when Class is first loaded.
    //Only static variables can be accessed
    count++;
    System.out.println("\nStatic Initializer");//i = 6;//COMPILER ERROR
    System.out.println("Count when Static Initializer is run is " + count);
  }

  public static void main(String[] args) {
    InitializerExamples example = new InitializerExamples();
    InitializerExamples example2 = new InitializerExamples();
    InitializerExamples example3 = new InitializerExamples();
  }
}