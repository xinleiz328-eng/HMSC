package com.itheima.consumer.mq;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SpringRabbitListener {
    @RabbitListener(queues = "simple.queue")
    public void listenSimpleQueue(String message){

        log.info("消费者接收到的消息是：【{}】",message);
    }

    @RabbitListener(bindings = @QueueBinding(
            value =@Queue(name = "direct.queue1",durable = "true"),
            exchange = @Exchange(name = "hmall.direct",type = ExchangeTypes.DIRECT),
            key ={"red","blue"}
    ))
    public void listenDirectQueue(String message){

        log.info("消费者接收到的消息是：【{}】",message);
    }




}
