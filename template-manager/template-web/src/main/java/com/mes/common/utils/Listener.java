package com.mes.common.utils;

import com.mes.config.AmqpConfig;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 消费者监听消费消息
 * 步骤1 初始化rabbitmq连接工厂
 * 步骤2 设置交换机类型及名称
 * 步骤3 声明队列
 * 步骤4 将队列绑定到交换机
 * 步骤5 监听队列信息并处理消息
 * @author liukl
 * @date 2018/3/21
 */
@Configuration
@RabbitListener(queues = AmqpConfig.ROUTINGKEY)
public class Listener {
    private static final Logger LOGGER = LoggerFactory.getLogger(Listener.class);
    /**
     * rabbitmq连接工厂类
     */
    private ConnectionFactory connectionFactory;

    /**
     * 初始化rabbitmq连接工厂
     * @param connectionFactory 连接工厂
     */
    @Autowired
    public Listener(ConnectionFactory connectionFactory){
        this.connectionFactory=connectionFactory;
    }

    /**
     * 设置交换机类型及名称(默认配置为持久化不自动删除)
     * FanoutExchange: 将消息分发到所有的绑定队列，无routingkey的概念
     * HeadersExchange ：通过添加属性key-value匹配
     * DirectExchange:按照routingkey分发到指定队列
     * TopicExchange:多关键字匹配
     */
    @Bean
    public DirectExchange defaultExchange() {
        return new DirectExchange(AmqpConfig.EXCHANGE);
    }

    /**
     * 声明队列(可持久化)
     * @return 队列对象
     */
    @Bean
    public Queue queue() {
        //队列持久
        return new Queue("spring-boot-queue", true);

    }

    /**
     * 将队列绑定到交换机
     * @return 绑定对象
     */
    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(defaultExchange()).with(AmqpConfig.ROUTINGKEY);
    }

    /**
     * 监听队列信息并处理消息
     * 确认消费成功设置：channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
     * 重新放入队列：channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
     * 抛弃此条消息：channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
     * @return 简单消息监听容器
     */
    @Bean
    public SimpleMessageListenerContainer messageContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        //监听的队列
        container.setQueues(queue());
        container.setExposeListenerChannel(true);
        container.setMaxConcurrentConsumers(1);
        container.setConcurrentConsumers(1);
        //设置确认模式手工确认
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        container.setMessageListener((ChannelAwareMessageListener)(Message message, Channel channel)->{
            byte[] body = message.getBody();
            LOGGER.info("receive msg : " + new String(body));
            //确认消息成功消费
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        });
        return container;
    }

}
