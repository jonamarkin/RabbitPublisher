package com.markin.rabbitpublisher;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

//    @Autowired
//    private RabbitTemplate queueSender;
//
//    @GetMapping
//    public String send(){
//        queueSender.send("test message");
//        return "ok. done";
//    }




    private final RabbitTemplate queueSender;

    public TestController(RabbitTemplate queueSender) {
        this.queueSender = queueSender;
    }

    @GetMapping
    public String send() throws JsonProcessingException {

        String mensagem = "test message";

        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setHeader("ultima", "sim");
        Message message = new Message(mensagem.getBytes(), messageProperties);

        queueSender.convertAndSend("testrabbit", "rabbit-test", message);
        return "ok. done";
    }
}
