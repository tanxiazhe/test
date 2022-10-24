/**
 * 
 */
package com.test.loadClass;

/**
 * @author 
 *
 */
public class Son extends Father {
    String name;

    Son() {
        // super("a");
        System.out.println("Son default constructor.");
    }

    public Son(String name) {
        super("a");
        this.name = name;
    }

    @Override
    public String toString() {
        return "Son [name=" + name + "]";
    }

    public static void main(String[] args) {
         Son f;
         f = new Son("son");
         System.out.println(f);
//        Father fa = new Father();
//        System.out.println(fa instanceof Son);
    }

    @Override
    public void queryBOs(String filter, String orderBy, Integer limit, Integer offset) {
        System.out.println("1");
    }

}
