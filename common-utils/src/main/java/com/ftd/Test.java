package com.ftd;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
/**
 * 一句话描述这个类的作用
 *
 * @author liukl
 * @date 2018/3/14
 */
public class Test {
    private final static String QUEUE_NAME = "hello";
    public static void main(String[] args) throws  Exception{
        ConnectionFactory factory = new ConnectionFactory();

        factory.setHost("39.108.57.32");
        factory.setUsername("admin");
        factory.setPassword("admin");
        Connection connection = null;
        Channel channel = null;

        connection = factory.newConnection();
        channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = "Hello World!";
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
        System.out.println(" [Producer] Sent '" + message + "'");

        channel.close();
        connection.close();
    }
}
