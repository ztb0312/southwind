package com.ztb.work;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListeners;
import org.springframework.stereotype.Component;

@Component
public class WorkCustomer {

    //消费者1
    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void receive1(String message){

        System.out.println("message1"+message);
    }

    //消费者2
    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void  receive2(String message){

        System.out.println("message2"+message);
    }



}
