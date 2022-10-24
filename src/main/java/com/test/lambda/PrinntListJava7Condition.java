/**
 * 
 */
package com.test.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.spring.ioc.springBeanTest.lifeCycle.Person;

/**
 * @author 
 *
 */
public class PrinntListJava7Condition {

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(new Person("a", "xx", 111), new Person("b", "bb2", 211),
                new Person("c", "hh", 311), new Person("a2", "bb5", 411), new Person("t", "aa", 511));
        System.out.println("print all");
        printAll(people);
        Collections.sort(people, new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAddress().compareTo(o2.getAddress());
            }
        });
        System.out.println("after sort by address, print all");
        printAll(people);

        System.out.println("print all starting with a");
        printAllCondition(people, new Condition() {

            @Override
            public boolean test(Person o1) {
                return o1.getAddress().startsWith("a");
            }

        });

    }

    /**
     * @param people
     */
    private static void printAllCondition(List<Person> people, Condition c) {
        for (Person p : people) {
            if (c.test(p))
                System.out.println(p);
        }
    }

    /**
     * @param people
     */
    private static void printAll(List<Person> people) {
        for (Person p : people) {
            System.out.println(p);
        }
    }

    interface Condition {
        boolean test(Person p);
    }

}
