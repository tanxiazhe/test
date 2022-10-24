package com.test;

public class FinalTest {
    final Employee employee;

    FinalTest() {
        Employee emplo = new Employee();
        employee = emplo;
        System.out.println(employee.getEmail());
        emplo.setEmail("aa");
        System.out.println(employee.getEmail());
    }

    public static void main(String[] args) {
        new FinalTest();
    }

}
