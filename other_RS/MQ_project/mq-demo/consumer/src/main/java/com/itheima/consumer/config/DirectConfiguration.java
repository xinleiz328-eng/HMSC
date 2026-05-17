package com.itheima.consumer.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectConfiguration {
    @Bean
    public DirectExchange directExchange(){
        //return new DirectExchange("hmall.direct")
        return ExchangeBuilder.directExchange("hmall.direct").build();
    }

    @Bean
    public Queue directQueue1(){
        // return QueueBuilder.durable("direct.queue1").build();
        return new Queue("direct.queue1");
    }


    @Bean
    public Binding directQueue1Bindingblue(Queue directQueue1, DirectExchange directExchange){
        return BindingBuilder.bind(directQueue1).to(directExchange).with("blue");
    }

    @Bean
    public Binding directQueue1Bindingred(Queue directQueue2, DirectExchange directExchange){
        return BindingBuilder.bind(directQueue2).to(directExchange).with("red");
    }


    @Bean
    public Queue directQueue2(){
        // return QueueBuilder.durable("direct.queue1").build();
        return new Queue("direct.queue2");
    }


    @Bean
    public Binding directQueue2Bindingyellow(Queue directQueue1, DirectExchange directExchange){
        return BindingBuilder.bind(directQueue1).to(directExchange).with("yellow");
    }

    @Bean
    public Binding directQueue2Bindingred(Queue directQueue2, DirectExchange directExchange){
        return BindingBuilder.bind(directQueue2).to(directExchange).with("red");
    }


    //绑定繁琐，解决思路使用RabbitListener绑定

}
