package com.anxpp.io.calculator.nio;

import java.util.Random;

/**
 * 测试方法
 * 
 * @author yangtao__anxpp.com
 * @version 1.0
 */
public class Test {
    // 测试主方法
    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception {
        // // 运行服务器
        // Server.start();
        // // 避免客户端先于服务器启动前执行代码
        // Thread.sleep(100);
        // // 运行客户端
        // Client.start();
        // while (Client.sendMsg(new Scanner(System.in).nextLine()))
        // ;
        // 运行服务器
        new Thread(new Runnable() {
            @Override
            public void run() {
                Server.start();
            }
        }).start();
        // 避免客户端先于服务器启动前执行代码
        Thread.sleep(100);
        // 运行客户端
        new Thread(new Runnable() {
            @SuppressWarnings("static-access")
            @Override
            public void run() {
                try {
                    Client.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        Thread.sleep(10000);
        char operators[] = { '+', '-', '*', '/' };
        Random random = new Random(System.currentTimeMillis());
        while (true) {
            // 随机产生算术表达式
            String expression = random.nextInt(10) + "" + operators[random.nextInt(4)]
                    + (random.nextInt(10) + 1);
            try {
                Client.send(expression);
                Thread.currentThread().sleep(random.nextInt(10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }

    }
}