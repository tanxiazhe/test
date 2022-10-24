package com.test;

import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;

import com.test.algorithm.TestTree;
import org.apache.commons.lang.StringUtils;

public class Test {

    public static void main(String[] args) throws IOException {

        // String urlParameters = "param1=a&param2=b&param3=c";
        // byte[] postData = urlParameters.getBytes( StandardCharsets.UTF_8 );
        // int postDataLength = postData.length;
        // String request = "http://example.com/index.php";
        // URL url = new URL( request );
        // HttpURLConnection conn= (HttpURLConnection) url.openConnection();
        // conn.setDoOutput( true );
        // conn.setInstanceFollowRedirects( false );
        // conn.setRequestMethod( "POST" );
        // conn.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded");
        // conn.setRequestProperty( "charset", "utf-8");
        // conn.setRequestProperty( "Content-Length", Integer.toString( postDataLength ));
        // conn.setUseCaches( false );
        // try( DataOutputStream wr = new DataOutputStream( conn.getOutputStream())) {
        // wr.write( postData );
        // }

        // String password = null;
        // if (!StringUtils.equals(password, "{{PASSWORD}}")) {
        // System.out.println("true");
        // } else {
        // System.out.println("false");
        // }
        // Employee e = new Employee();
        // e.setPassword(null);
        // System.out.println(e.getPassword());
        // if (!"{{PASSWORD}}".equals(password)) {
        // System.out.println("true");
        // } else {
        // System.out.println("false");
        // }

        // String link = "http://idp?request=xagag&locale=";
        // int first = link.indexOf("locale=");
        // System.out.println(first);
        // if (first != link.length() - 7) {
        // String refineLink = link.substring(0, first) + "locale=EN_US";
        // System.out.println(refineLink);
        // }

        // System.out.println("classPath: " + Test.class.getClassLoader().getResource("").toString());

        // Long[] ids = {};
        // if (ids == null) {
        // System.out.println("null");
        // }

        // String a = "a";
        // String b = null;
        // System.out.println(a.equals(b));

        // char a = '中';
        // System.out.println(a);

        // Employee e1 = new Employee("bb");
        // Employee e2 = new Employee("cc");
        // System.out.println(e1 + ", " + e2);
        // swap(e1, e2);
        // System.out.println(e1 + ", " + e2);

        // testConvert();

        // testArrayList2Array();
        // Son son = new Son();
        // son.queryBOs(null, null, null, null);

        // String fromVersion = "16.00.12";
        // String[] aa = fromVersion.split("\\.");
        //
        // // String[] aa = "aaa|bbb|ccc".split("\\|"); 这样才能得到正确的结果
        //
        // for (int i = 0; i < aa.length; i++) {
        //
        // System.out.println("--" + aa[i]);
        //
        // }

        // boolean flag = true;
        // passParm("", flag);
        // System.out.println(flag);

        // Boolean a = null;
        // boolean b = a;
        // System.out.println(b);

        // String ad = "{\"firstName\": \"\", \"lastName\": \"testnull\"}";
        // String ad2 = "{\"firstName\": \"a\", \"lastName\": \"testnull\"}";
        // String ad3 = null;
        // // EmployeeEmailServiceImpl e = new EmployeeEmailServiceImpl();
        // // System.out.println(e.getTrialTenantUserRealFirstName(ad3, "jaja"));
        //
        // Map<String, Object> params = new HashMap<String, Object>();
        //
        // params.put("email", "aa");
        // params.put("email", "aa22");
        // System.out.println(params.get("email"));

        // String s = "/home/penny/.jenkins/workspace/check-frw-version/repos/attachment";
        // System.out.println(getString(s));

        // String s2 = "/home/penny/.jenkins/workspace/check-frw-version/repos/campaign/campaign-upgrade";
        // String workspace = "/home/penny/.jenkins/workspace/check-frw-version/repos/";
        // int index = s2.indexOf(workspace);
        // String s3 = s2.substring(index + workspace.length() - 1);
        //
        // System.out.println(s3);
        // print();

        // String a = "com.sap.sme.anw:channel-common:jar:1.1.1_3.4.1";
        // String a2 = "com.sap.sme.anw:vault-common-java:jar:1.0.0";
        // System.out.println(isFrwPackage(a2));

        // mapprint();
        // emptyAndBlank();
        // char2String();
        // System.out.println(isPalindrome(-2147483648));
        // formatString();
        // booleanPrint();

        // String test = "aa";
        // if (test.equals("a")) {
        // System.out.println("1");
        // } else {
        // System.out.println("2");
        // }
        box2();

        String s = "aa";


    }

    public static void box() {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer c2 = new Integer(321);
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println(c == d);
        System.out.println(c == c2);
        System.out.println(e == f);
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println(g == a + b);
        System.out.println(g.equals(a + b));
        System.out.println(c2 == e);

    }

    public static void box2() {
        System.out.println("<-128~127以内的Integer值，Integer x = value;的方式赋值！>");
        Integer i = 127;
        Integer j = 127;
        System.out.println("i=" + i + ",j =" + j);
        System.out.println("i == j：" + (i == j) + "<--比较-->i.equals(j):" + i.equals(j));
        System.out.println("<-128~127以外的Integer值，Integer x = value;的方式赋值！>");
        Integer m = 128;
        Integer n = 128;
        System.out.println("m=" + m + ",n =" + n);
        System.out.println("m == n：" + (m == n) + "<--比较-->m.equals(n):" + m.equals(n));
        System.out.println();

        System.out.println("<任意Integer值，Integer x = new Integer(value);的方式赋值！>");
        Integer x = new Integer(299);
        Integer y = new Integer(299);
        System.out.println("x=" + x + ",y =" + y);
        System.out.println("x == y：" + (x == y) + "<--比较-->x.equals(y):" + x.equals(y));
    }

    public static void booleanPrint() {
        Boolean a = false;
        if (a) {
            System.out.println("true");
        }
    }

    public static void formatString() {
        String payload = String.format("{\"param\":{ \"customerId\" : \"%s\"} }", 12222);
        System.out.println(payload);

    }

    public void printbas() {
        int x = -2147483648;
        System.out.println(x + "　ａｂｓ　" + Math.abs(x));
        System.out.println("double类型：\t \t" + java.lang.Math.abs(2.55d));

        System.out.println("float类型：\t\t" + java.lang.Math.abs(-2.5f));

        System.out.println("int类型：\t\t" + java.lang.Math.abs(-2));

        System.out.println("long类型：\t\t" + java.lang.Math.abs(-2147483648));
    }

    public static boolean isPalindrome(int y) {
        int x = y;
        if (y < 0) {
            x = y * (-1);
            System.out.println("1 " + x);
        }
        System.out.println(x);
        while (x > 0) {
            System.out.println(" x= " + x + "  x/10=" + x / 10 + " x%10=" + x % 10);
            if (x / 10 == x % 10)
                x = (x - x / 10 - x % 10) / 10;
            return false;
        }
        System.out.println(x);
        if (x == 0 || x < 10) {
            return true;
        }
        return false;
    }

    static void char2String() {
        String strStringType = "my string"; // 创建一个字符串变量strStringType
        char[] chrCharArray; // 创建一个字符数组chrCharArray
        chrCharArray = strStringType.toCharArray(); // 将字符串变量转换为字符数组
        String strStringType2 = String.valueOf(chrCharArray); // 将字符数组转换为字符串
        System.out.println(Arrays.toString(chrCharArray));
        System.out.println(strStringType2);
    }

    static void emptyAndBlank() {
        String s1 = "", s2 = null, s3 = " ", s4;
        System.out.println(
                " s1 " + StringUtils.isEmpty(s1) + " s2 " + StringUtils.isEmpty(s2) + " s3 " + StringUtils.isEmpty(s3));
        System.out.println(
                " s1 " + StringUtils.isBlank(s1) + " s2 " + StringUtils.isBlank(s2) + " s3 " + StringUtils.isBlank(s3));
    }

    static boolean isFrwPackage(String dependency) {
        if (dependency.contains("anw-frw-package") || dependency.contains("com.sap.sme.anw:common:")
                || dependency.contains("service-layer") || dependency.contains("service-frw")
                || dependency.contains("odata-frw") || dependency.contains("ops-tools")
                || dependency.contains("api-frw") || dependency.contains("bo-frw-common")
                || dependency.contains("bo-frw-ns") || dependency.contains("client-frw")
                || dependency.contains("ui-meta-frw") || dependency.contains("ui-meta-service")
                || dependency.contains("bo-event-frw") || dependency.contains("event-thin-frw")
                || dependency.contains("securestorage") || dependency.contains("crypt")
                || dependency.contains("uuid-generator") || dependency.contains("bo-frw-upgrade")
                || dependency.contains("hana-upgrade-core") || dependency.contains("hana-schema-upgrade")
                || dependency.contains("dbupgrade-frw") || dependency.contains("extension-frw")
                || dependency.contains("md-schema-upgrade") || dependency.contains("oauth-client")) {
            return true;
        }
        return false;
    }

    static void swap(Employee e1, Employee e2) {
        Employee t = e1;
        e1 = e2;
        e2 = t;
    }

    static void testConvert() {
        Employee e = new Employee();
        Manager m = new Manager();
        System.out.println(e);
        e = m;// 父类的引用可以直接用子类的引用进行赋值。子赋值给父
        e = new Manager();
        System.out.println(e);
        m = (Manager) e;// 子类的引用可以间接用父类的引用进行赋值，强制类型转换，父强制转换成子

    }

    static void testArrayList2Array() {
        List<Employee> list = new ArrayList<Employee>();
        int i = 5;
        while (i-- > 0) {
            Employee e = new Employee();
            list.add(e);
        }
        System.out.println(list.size());
        list.add(new Employee());
        System.out.println(list.size());
        Employee[] es = new Employee[list.size()];
        list.toArray(es);
        for (Employee e : es) {
            System.out.println(e);
        }
    }

    static void passParm(String a, boolean b) {
        System.out.println("1:" + b);
        b = false;
        System.out.println("2" + b);
    }

    static String getString(String s) {
        String arr[] = s.split("/");
        return arr[arr.length - 1];
    }

    static void print() {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("\nservice-case", "");
        hashMap.put("com.sap.sme.anw:service-case-rest:jar:1.1.0",
                "/home/penny/.jenkins/workspace/check-frw-version/repos/service-case/service-case");
        hashMap.put("com.sap.sme.anw:service-case-metadata:jar:1.1.0 ",
                "/home/penny/.jenkins/workspace/check-frw-version/repos/service-case/service-case");
        hashMap.put("com.sap.sme.anw:service-case-rest:jar:1.1.02",
                "/home/penny/.jenkins/workspace/check-frw-version/repos/service-case/service-case");
        hashMap.put("com.sap.sme.anw:service-case-metadata:jar:1.1.02 ",
                "/home/penny/.jenkins/workspace/check-frw-version/repos/service-case/service-case");
        hashMap.put("com.sap.sme.anw:service-case-rest:jar:1.1.03",
                "/home/penny/.jenkins/workspace/check-frw-version/repos/service-case/service-case");
        hashMap.put("com.sap.sme.anw:service-case-metadata:jar:1.1.04 ",
                "/home/penny/.jenkins/workspace/check-frw-version/repos/service-case/service-case");
        hashMap.put("com.sap.sme.anw:service-case-rest:jar:1.1.04",
                "/home/penny/.jenkins/workspace/check-frw-version/repos/service-case/service-case");
        hashMap.put("com.sap.sme.anw:service-case-metadata:jar:1.1.04 ",
                "/home/penny/.jenkins/workspace/check-frw-version/repos/service-case/service-case");

        hashMap.put("\nservice", "");
        hashMap.put("com.sap.sme.anw:service-case-rest:jar:1.1.0w",
                "/home/penny/.jenkins/workspace/check-frw-version/repos/service-case/service-case");
        hashMap.put("com.sap.sme.anw:service-case-metadata:jar:1.1.0w ",
                "/home/penny/.jenkins/workspace/check-frw-version/repos/service-case/service-case");
        hashMap.put("com.sap.sme.anw:service-case-rest:jar:1.1.02w",
                "/home/penny/.jenkins/workspace/check-frw-version/repos/service-case/service-case");
        hashMap.put("com.sap.sme.anw:service-case-metadata:jar:1.1.02w ",
                "/home/penny/.jenkins/workspace/check-frw-version/repos/service-case/service-case");
        hashMap.put("com.sap.sme.anw:service-case-rest:jar:1.1.03w",
                "/home/penny/.jenkins/workspace/check-frw-version/repos/service-case/service-case");
        hashMap.put("com.sap.sme.anw:service-case-job:jar:1.1.0",
                "/home/penny/.jenkins/workspace/check-frw-version/repos/service-case/service-case");
        hashMap.put("com.sap.sme.anw:service-case-rest:jar:1.1.04w",
                "/home/penny/.jenkins/workspace/check-frw-version/repos/service-case/service-case");
        hashMap.put("com.sap.sme.anw:migration-uuid-offset:jar:1.0.0-SNAPSHOT",
                "/home/penny/.jenkins/workspace/check-frw-version/repos/service-case/service-case");

        Set<Entry<String, String>> its = hashMap.entrySet();
        for (Entry<String, String> it : its) {
            System.out.printf("\t%-20s\t\t%20s\n", it.getKey(), it.getValue());
        }
    }

    static void mapprint() {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("\nservice-case", "");
        hashMap.put("com.sap.sme.anw:service-case-rest:jar:1.1.0",
                "/home/penny/.jenkins/workspace/check-frw-version/repos/service-case/service-case");
        hashMap.put("com.sap.sme.anw:service-case-metadata:jar:1.1.0 ",
                "/home/penny/.jenkins/workspace/check-frw-version/repos/service-case/service-case");
        hashMap.put("com.sap.sme.anw:service-case-rest:jar:1.1.02",
                "/home/penny/.jenkins/workspace/check-frw-version/repos/service-case/service-case");
        hashMap.put("com.sap.sme.anw:service-case-metadata:jar:1.1.02 ",
                "/home/penny/.jenkins/workspace/check-frw-version/repos/service-case/service-case");
        hashMap.put("com.sap.sme.anw:service-case-rest:jar:1.1.03",
                "/home/penny/.jenkins/workspace/check-frw-version/repos/service-case/service-case");
        hashMap.put("com.sap.sme.anw:service-case-metadata:jar:1.1.04 ",
                "/home/penny/.jenkins/workspace/check-frw-version/repos/service-case/service-case");
        hashMap.put("com.sap.sme.anw:service-case-rest:jar:1.1.04",
                "/home/penny/.jenkins/workspace/check-frw-version/repos/service-case/service-case");
        hashMap.put("com.sap.sme.anw:service-case-metadata:jar:1.1.04 ",
                "/home/penny/.jenkins/workspace/check-frw-version/repos/service-case/service-case");

        hashMap.put("\nservice", "");
        hashMap.put("com.sap.sme.anw:service-case-rest:jar:1.1.0w",
                "/home/penny/.jenkins/workspace/check-frw-version/repos/service-case/service-case");
        hashMap.put("com.sap.sme.anw:service-case-metadata:jar:1.1.0w ",
                "/home/penny/.jenkins/workspace/check-frw-version/repos/service-case/service-case");
        hashMap.put("com.sap.sme.anw:service-case-rest:jar:1.1.02w",
                "/home/penny/.jenkins/workspace/check-frw-version/repos/service-case/service-case");
        hashMap.put("com.sap.sme.anw:service-case-metadata:jar:1.1.02w ",
                "/home/penny/.jenkins/workspace/check-frw-version/repos/service-case/service-case");
        hashMap.put("com.sap.sme.anw:service-case-rest:jar:1.1.03w",
                "/home/penny/.jenkins/workspace/check-frw-version/repos/service-case/service-case");
        hashMap.put("com.sap.sme.anw:service-case-job:jar:1.1.0",
                "/home/penny/.jenkins/workspace/check-frw-version/repos/service-case/service-case");
        hashMap.put("com.sap.sme.anw:service-case-rest:jar:1.1.04w",
                "/home/penny/.jenkins/workspace/check-frw-version/repos/service-case/service-case");
        hashMap.put("com.sap.sme.anw:migration-uuid-offset:jar:1.0.0-SNAPSHOT",
                "/home/penny/.jenkins/workspace/check-frw-version/repos/service-case/service-case");

        Map<String, HashMap<String, String>> map = new HashMap<String, HashMap<String, String>>();
        map.put("service-case", hashMap);
        map.put("employee", hashMap);
        Set<Entry<String, HashMap<String, String>>> sets = map.entrySet();
        for (Entry<String, HashMap<String, String>> set : sets) {
            System.out.printf("\t%-20s\t\t%20s\n", set.getKey(), null);
            Set<Entry<String, String>> its = set.getValue().entrySet();
            for (Entry<String, String> it : its) {
                System.out.printf("\t%-20s\t\t%20s\n", it.getKey(), it.getValue());
            }

        }

        System.out.println("-----------");
        for (Map.Entry<String, HashMap<String, String>> entry : map.entrySet()) {
            System.out.printf("\t%-20s\t\t%20s\n", entry.getKey(), null);
            Set<Entry<String, String>> its = entry.getValue().entrySet();
            for (Entry<String, String> it : its) {
                System.out.printf("\t%-20s\t\t%20s\n", it.getKey(), it.getValue());
            }
        }
    }



}
