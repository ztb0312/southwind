package com.ztb.test;

import com.ztb.RabbitmqSpringbootApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = RabbitmqSpringbootApplication.class)
@RunWith(SpringRunner.class)
public class TestRabbitMQ {

    //注入rabbitTemplet工具
    @Autowired
    private RabbitTemplate rabbitTemplate;
    //hello word 一对一· 直连模型
    @Test
    public void test(){
        rabbitTemplate.convertAndSend("hello","hello  word");
    }



    //work模型
    @Test
    public void testWork(){

        for (int i=0;i<10;i++) {
            rabbitTemplate.convertAndSend("work", "work 模型");
        }
    }


    //fanout 广播模型
    @Test
    public void testFanOut(){

            rabbitTemplate.convertAndSend("logs","", "fanout 模型");

    }



    //routing的模型
    @Test
    public void testRouting(){

        rabbitTemplate.convertAndSend("directs","error","发送info类型的路由的类的信息");
    }




    //topic   动态路由订阅模型
    @Test
    public void testTopic(){

        rabbitTemplate.convertAndSend("topics","service.log","services  类型的路由的类的信息");

    }

}
