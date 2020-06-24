package com.ztb.hello;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queuesToDeclare = @Queue("hello"))
//启动队列监听 ，queuesToDeclare  声明队列
public class HelloCustomer {

    @RabbitHandler
    public void recievel(String message){//随便指定一个方法
        System.out.println("message======="+message);





    }



}
