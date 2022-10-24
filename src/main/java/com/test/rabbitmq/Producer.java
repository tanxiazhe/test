package com.test.rabbitmq;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Producer {
  // exchange type
  public enum XT {
    DEFAULT,
    FANOUT,
    DIRECT,
    TOPIC,
    HEADERS
  }

  private static final String QUEUE_NAME = "log2";
  private static Scanner scanner = new Scanner(System.in);
  private static String message = "";
  public static String XCHG_NAME = "xchg3";

  public static void main(String[] args) throws IOException {
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("localhost"); // 使用默认端口连接本地rabbitmq服务器

    Connection connection = factory.newConnection(); // 声明一个连接
    Channel channel = connection.createChannel(); // 声明消息通道
    System.out.println("please input exchange type,0:default, 1:fanout, 2: direct, 3: topic, 4: headers. then enter newline.");

    // exchange类型 参考:http://stephansun.iteye.com/blog/1452853
    String msg = scanner.nextLine();
    msg = StringUtils.split(msg, " ")[0];
    int i = Integer.parseInt(msg);
    XT xt = XT.values()[i];
    switch (xt) {
      case DEFAULT: // 默认，向指定的队列发送消息，消息只会被一个consumer处理,多个消费者消息会轮训处理,消息发送时如果没有consumer，消息不会丢失
        // 为消息通道绑定一个队列
        // 队列的相关参数需要与第一次定义该队列时相同，否则会出错
        // 参数1：队列名称
        // 参数2：为true时server重启队列不会消失
        // 参数3：队列是否是独占的，如果为true只能被一个connection使用，其他连接建立时会抛出异常
        // 参数4：队列不再使用时是否自动删除（没有连接，并且没有未处理的消息)
        // 参数5：建立队列时的其他参数
        channel.queueDeclare(QUEUE_NAME, true, false, true, null);
        System.out.println("please input message then enter newline.");
        while (GetInputString()) {

          // 向server发布一条消息
          // 参数1：exchange名字，若为空则使用默认的exchange
          // 参数2：routing key
          // 参数3：其他的属性
          // 参数4：消息体
          // RabbitMQ默认有一个exchange，叫default exchange，它用一个空字符串表示，它是direct exchange类型，
          // 任何发往这个exchange的消息都会被路由到routing key的名字对应的队列上，如果没有对应的队列，则消息会被丢弃
          channel.basicPublish("", QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN,
              message.getBytes()); // 设置消息为持久化，服务器重启不会丢失

          System.out.println("Send " + message);
        }
        break;
      case FANOUT:
        // 广播给所有队列 接收方也必须通过fanout交换机获取消息,所有连接到该交换机的consumer均可获取消息
        // 如果producer在发布消息时没有consumer在监听，消息将被丢弃 --- 重要。

        // 定义一个交换机
        // 参数1：交换机名称
        // 参数2：交换机类型
        // 参数3：交换机持久性，如果为true则服务器重启时不会丢失
        // 参数4：交换机在不被使用时是否删除
        // 参数5：交换机的其他属性
        channel.exchangeDeclare(XCHG_NAME, "fanout", true, true, null);
        System.out.println("please input message then enter newline.");
        while (GetInputString()) {
          // 发送一条广播消息,参数2此时无意义
          channel.basicPublish(XCHG_NAME, "", null, message.getBytes());

          System.out.println("Send " + message);
        }
        break;
      case DIRECT:
        // 向所有绑定了相应routing key的队列发送消息
        // 如果producer在发布消息时没有consumer在监听，消息将被丢弃  ---跟 fanout一样的行为，重要。
        // 如果有多个consumer监听了相同的routing key 则他们都会受到消息
        channel.exchangeDeclare(XCHG_NAME, "direct", true, true, null);

        System.out.println("please input routingkey like info or warning,  type a blank and  message , then enter newline.");
        while (GetInputString()) {
          // input like : info message
          String[] temp = StringUtils.split(message, " ");
          channel.basicPublish(XCHG_NAME, temp[0], null, temp[1].getBytes());
          System.out.println("Send " + message);
        }
        break;
      case TOPIC:
        // 与direct模式有类似之处，都使用routing key作为路由.
        // 如果producer在发布消息时没有consumer在监听，消息将被丢弃  ---跟 fanout一样的行为，重要。
        // 不同之处在于direct模式只能指定固定的字符串，而topic可以指定一个字符串模式
        channel.exchangeDeclare(XCHG_NAME, "topic", true, true, null);
        System.out.println("please input routingkey like warning.# or *.blue,  type a blank and  message , then enter newline.");
        while (GetInputString()) {
          // input like : topic message
          String[] temp = StringUtils.split(message, " ");
          channel.basicPublish(XCHG_NAME, temp[0], null, temp[1].getBytes());
          System.out.println("Send " + message);
        }
        break;
      case HEADERS:
        // 与topic和direct有一定相似之处，但不是通过routing key来路由消息
        // 通过headers中词的匹配来进行路由
        channel.exchangeDeclare(XCHG_NAME, "headers", true, true, null);
        System.out.println("please input headers  name and sex, default value test max , type  message , then enter newline.");

        while (GetInputString()) {
          // input like : headers message
          String[] temp = StringUtils.split(message, " ");

          Map<String, Object> headers = new HashMap<String, Object>();
          headers.put("name", temp[0]); // 定义headers
          headers.put("sex", temp[1]);
          AMQP.BasicProperties.Builder builder =
              new AMQP.BasicProperties.Builder().headers(headers);

          channel.basicPublish(XCHG_NAME, "", builder.build(),
              temp[2].getBytes()); // 根据headers路由到相应的consumer
          System.out.println("Send " + message);
        }
        break;
    }
    channel.close();
    connection.close();
  }

  private static boolean GetInputString() {
    message = scanner.nextLine();
    if (message.length() == 0) {
      return false;
    }
    return true;
  }
}