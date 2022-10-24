package com.test.nestedclass;

public class InnerDemo {

    public int val = 12;// 变量
    public static int staticVal = 13;// 实例变量(常量)

    public final int FINALVAL = 23;
    public final static int FSVAL = 33;

    public static void main(String[] args) {
        InnerDemo demo = new InnerDemo();
        InnerClass innerClass = demo.new InnerClass();
        innerClass.change();

        System.out.println("demo.val " + demo.val);// 12 TODO 值没变
        System.out.println("staticVal " + staticVal);// 23 TODO 值改变了
        System.out.println("demo.FINALVAL  " + demo.FINALVAL);// 23
        System.out.println("FSVAL " + FSVAL);// 33
        System.out.println(innerClass);
    }

    class InnerClass {
        public void change() {
            InnerDemo demo = new InnerDemo();
            demo.val = 33;
            staticVal = 23;

            // FINALVAL = 55; TODO 编译报错 The final field InnerDemo.FSVAL cannot be assigned
            // FSVAL = 44; TODO 编译报错 The final field InnerDemo.FSVAL cannot be assigned
        }

        @Override
        public String toString() {
            return "inner class";
        }

    }

}