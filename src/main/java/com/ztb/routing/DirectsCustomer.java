package com.ztb.routing;

import ch.qos.logback.core.boolex.EvaluationException;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DirectsCustomer {

    //消费者1



    @RabbitListener(bindings = {
           @QueueBinding(
            value= @Queue,//创建临时队
            exchange = @Exchange(value = "directs",type = "direct"),//自定义交换机类型和名称
            key = {"info","error","warn"}
           )
    })
    public void receive1(String message){
        System.out.println("message1  ="+message);
    }

    //消费者2
    @RabbitListener(bindings = {
            @QueueBinding(
                    value= @Queue,//创建临时队列
                    exchange = @Exchange(value = "directs",type = "direct"),//自定义交换机类型和名称
                    key = {"error"}
            )
    })

    public void receive2(String message){
        System.out.println("message2   ="+message);
    }
}
