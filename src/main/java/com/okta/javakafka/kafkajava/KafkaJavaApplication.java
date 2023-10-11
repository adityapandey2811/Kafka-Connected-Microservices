package com.okta.javakafka.kafkajava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.okta.javakafka.controller"})
public class KafkaJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaJavaApplication.class, args);
    }


}