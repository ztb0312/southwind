package com.ztb.topic;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicCustomer {

    //消费者1
    @RabbitListener(bindings = {
            @QueueBinding(
                    value= @Queue,//创建临时队
                    exchange = @Exchange(name = "topics",type = "topic"),//自定义交换机类型和名称
                    key = {"service.#","product.#","user.*"}
            )
    })


    public void receive1(String message){
        System.out.println("message1  ="+message);
    }

    //消费者2
    @RabbitListener(bindings = {
            @QueueBinding(
                    value= @Queue,//创建临时队列
                    exchange = @Exchange(name= "topics",type = "topic"),//自定义交换机类型和名称
                    key = {"user.save","user.*"}
            )
    })

    public void receive2(String message){
        System.out.println("message2   ="+message);
    }
}
