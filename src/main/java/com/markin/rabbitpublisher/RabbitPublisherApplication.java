package com.markin.rabbitpublisher;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class RabbitPublisherApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitPublisherApplication.class, args);
    }

}
