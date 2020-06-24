package com.ztb.fanout;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanOutCustomer {

@RabbitListener(bindings = {
        @QueueBinding(
                value=@Queue,//创建临时队列
                exchange=@Exchange(value = "logs",type = "fanout")//绑定交换机
        )
})
    public  void recive1(String message){
        System.out.println("message1 = "+message);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value=@Queue,//创建临时队列
                    exchange=@Exchange(value = "logs",type = "fanout")//绑定交换机
            )
    })
    public  void recive2(String message){
        System.out.println("message2 = "+message);
    }



}
