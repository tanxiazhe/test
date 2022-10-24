package com.test.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class MyServer {
  private int size = 1024;
  private ServerSocketChannel serverSocketChannel;

  private ByteBuffer byteBuffer ;
  private Selector selector;
  private int remoteClinetNum = 0;
  public MyServer(int port){
    try {
      initChannel(port);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void initChannel(int port) throws IOException {
    serverSocketChannel = ServerSocketChannel.open();
    serverSocketChannel.configureBlocking(false);
    serverSocketChannel.bind(new InetSocketAddress(port));
    System.out.println("listener on port:" + port);

    selector = Selector.open();

    serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

    byteBuffer= ByteBuffer.allocate(size);
  }

  private  void listener() throws Exception{
    while (true){
      int n = selector.select();
      if(n==0){
        continue;
      }
      Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
      while (iterator.hasNext()){
        SelectionKey key = iterator.next();
        if(key.isAcceptable()){
          ServerSocketChannel server = (ServerSocketChannel) key.channel();
          SocketChannel channel = server.accept();
          registerChannel(selector,channel,SelectionKey.OP_READ);
          remoteClinetNum++;
          System.out.println("\nonline client num: "+ remoteClinetNum);
          write(channel,"hello client".getBytes());
        }
        if(key.isReadable()){
          read(key);
        }
        iterator.remove();
      }
    }
  }

  private void read(SelectionKey key) throws IOException{
    SocketChannel channel = (SocketChannel) key.channel();
    int count;
    byteBuffer.clear();
    while((count = channel.read(byteBuffer) )> 0){
      byteBuffer.flip();
      while (byteBuffer.hasRemaining()){
        System.out.print((char) byteBuffer.get());
      }
      byteBuffer.clear();
    }
    if(count <0){
      channel.close();
    }
  }

  private void write(SocketChannel channel, byte[] bytes) throws IOException {
    byteBuffer.clear();
    byteBuffer.put(bytes);
    byteBuffer.flip();
    channel.write(byteBuffer);
  }

  private void registerChannel(Selector selector, SocketChannel channel, int opRead)
      throws IOException {
    if(channel == null){
      return;
    }
    channel.configureBlocking(false);
    channel.register(selector,opRead);
  }

  public static void main(String[] args) {
    MyServer server = new MyServer(9999);
    try {
      server.listener();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
