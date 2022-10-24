package com.anxpp.io.calculator.io;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Utils {
    // 异步发送消息
    public static void doWrite(SocketChannel channel, String request) throws IOException {
        // 将消息编码为字节数组
        byte[] bytes = request.getBytes();
        // 根据数组容量创建ByteBuffer
        ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
        // 将字节数组复制到缓冲区
        writeBuffer.put(bytes);
        // flip操作
        writeBuffer.flip();
        // 发送缓冲区的字节数组
        channel.write(writeBuffer);
        // ****此处不含处理“写半包”的代码
    }
}
