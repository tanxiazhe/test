/**
 *
 */
package com.test.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

/**
 * @author
 *
 */
public class Send {

  private final static String QUEUE_NAME = "hello";

  /**
   *
   * RabbitMQ默认有一个exchange，叫default exchange，它用一个空字符串表示，它是direct
   * exchange类型，任何发往这个exchange的消息都会被路由到routing
   * key的名字对应的队列上，如果没有对应的队列，则消息会被丢弃。这就是为什么代码中channel执行basicPulish方法时，第二个参数本应该为routing
   * key，却被写上了QUEUE_NAME。
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    // AMQP的连接其实是对Socket做的封装, 注意以下AMQP协议的版本号，不同版本的协议用法可能不同。
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("localhost");
    Connection connection = factory.newConnection();
    // 下一步我们创建一个channel, 通过这个channel就可以完成API中的大部分工作了。
    Channel channel = connection.createChannel();

    // 为了发送消息, 我们必须声明一个队列，来表示我们的消息最终要发往的目的地。
    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
    String message = "Hello World!";
    // 然后我们将一个消息发往这个队列。
    channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
    System.out.println("[" + message + "]");

    // 最后，我们关闭channel和连接，释放资源。
    channel.close();
    connection.close();
  }
}
