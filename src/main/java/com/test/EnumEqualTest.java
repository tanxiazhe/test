/**
 * 
 */
package com.test;

/**
 * @author 
 *
 */
public class EnumEqualTest {

    public static void main(String[] args) {
        EnumTest a = EnumTest.a;
        EnumTest a2 = EnumTest.a;
        System.out.println(a == a2);

        System.out.println(a.equals(a2));

    }
}

enum EnumTest {
    a, b
}
