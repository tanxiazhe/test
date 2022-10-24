package com.test.nestedclass;

public class Layer {
    // Layer类的成员变量

    private final String testStr = "testStr";

    // Person类，基类

    class Person {

        String name;

        Email email;

        public void setName(String nameStr) {

            this.name = nameStr;

        }

        public String getName() {

            return this.name;

        }

        public void setEmail(Email emailObj) {

            this.email = emailObj;

        }

        public String getEmail() {

            return this.email.getMailStr();

        }

        // 内部类的内部类，多层内部类

        class Email {

            String mailID;

            String mailNetAddress;

            Email(String mailId, String mailNetAddress) {

                this.mailID = mailId;

                this.mailNetAddress = mailNetAddress;

            }

            String getMailStr() {

                return this.mailID + "@" + this.mailNetAddress;

            }

        }

    }

    // 另一个内部类继承外部类本身

    class ChildLayer extends Layer {

        void print() {

            System.out.println(super.testStr);// 访问父类的成员变量

        }

    }

    // 另个内部类继承内部类Person

    class OfficePerson extends Person {

        void show() {

            System.out.println(name);

            System.out.println(getEmail());

        }

    }

    // 外部类的测试方法

    public void testFunction() {

        // 测试第一个内部类

        ChildLayer childLayer = new ChildLayer();

        childLayer.print();

        // 测试第二个内部类

        OfficePerson officePerson = new OfficePerson();

        officePerson.setName("abner chai");

        // 注意此处，必须用 对象.new 出来对象的子类对象

        // 而不是Person.new Email(...)

        // 也不是new Person.Email(...)

        officePerson.setEmail(officePerson.new Email("josserchai", "yahoo.com"));

        officePerson.show();

    }

    public static void main(String[] args) {

        Layer layer = new Layer();

        layer.testFunction();

    }

}