package com.anxpp.io.calculator.aio.server;

public class Server {
    private static int DEFAULT_PORT = 12345;
    private static AsyncServerHandler serverHandle;
    public volatile static long clientCount = 0;

    public static void start() {
        start(DEFAULT_PORT);
    }

    private static void start(int port) {
        if (serverHandle != null) {
            return;
        }
        serverHandle = new AsyncServerHandler(port);
        new Thread(serverHandle, "Server").start();
    }
}