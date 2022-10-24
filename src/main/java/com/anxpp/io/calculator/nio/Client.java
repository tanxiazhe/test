package com.anxpp.io.calculator.nio;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

import com.anxpp.io.calculator.io.Utils;

public class Client {
    private static String DEFAULT_HOST = "127.0.0.1";
    private static int DEFAULT_PORT = 12345;
    private static ClientHandle clientHandle;
    private static Selector selector;
    private static SocketChannel socketChannel;

    public static void start() throws Exception {
        start(DEFAULT_HOST, DEFAULT_PORT);
    }

    public static synchronized void start(String ip, int port) throws Exception {
        if (clientHandle != null)
            clientHandle.stop();

        try {
            // 创建选择器
            selector = Selector.open();
            // 打开监听通道
            socketChannel = SocketChannel.open();
            // 如果为 true，则此通道将被置于阻塞模式；如果为 false，则此通道将被置于非阻塞模式
            socketChannel.configureBlocking(false);// 开启非阻塞模式
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        clientHandle = new ClientHandle(ip, port, true, selector, socketChannel);
        new Thread(clientHandle, "Client").start();
    }

    // 向服务器发送消息
    public static void send(String expression) throws Exception {
        System.out.println("\n客户端发送的算术表达式为：" + expression);
        socketChannel.register(selector, SelectionKey.OP_READ);
        Utils.doWrite(socketChannel, expression);
    }

}