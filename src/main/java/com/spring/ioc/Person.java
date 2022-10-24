package com.spring.ioc;

public class Person {

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  private String name;

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  private String address;

  public long getPhone() {
    return phone;
  }

  public void setPhone(long phone) {
    this.phone = phone;
  }

  private long phone;

  public Person() {
  }

  public Person(String name, String address, long phone) {
    super();
    this.name = name;
    this.address = address;
    this.phone = phone;
  }

  @Override
  public String toString() {
    return "Person [name=" + name + ", address=" + address + ", phone=" + phone + "]";
  }
}
