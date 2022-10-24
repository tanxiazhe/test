package com.anxpp.io.calculator.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class Server {
    private static int DEFAULT_PORT = 12345;

    private static Selector selector;
    private static ServerSocketChannel serverChannel;

    private static ServerHandler serverHandle;

    public static void start() {
        start(DEFAULT_PORT);
    }

    public static synchronized void start(int port) {
        if (serverHandle != null)
            serverHandle.stop();

        try {
            // 创建选择器
            selector = Selector.open();
            // 打开监听通道
            serverChannel = ServerSocketChannel.open();
            // 如果为 true，则此通道将被置于阻塞模式；如果为 false，则此通道将被置于非阻塞模式
            serverChannel.configureBlocking(false);// 开启非阻塞模式
            // 绑定端口 backlog设为1024
            serverChannel.socket().bind(new InetSocketAddress(port), 1024);
            // 监听客户端连接请求
            serverChannel.register(selector, SelectionKey.OP_ACCEPT);
            // 标记服务器已开启
            System.out.println("服务器已启动，端口号：" + port + "\n");
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        serverHandle = new ServerHandler(true, selector);
        new Thread(serverHandle, "Server").start();
    }

}