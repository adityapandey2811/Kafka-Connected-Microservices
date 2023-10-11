package com.okta.javakafka.controller;

import com.okta.javakafka.configuration.SendService;
import com.okta.javakafka.configuration.TestConsumer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KafkaController {

    public KafkaController() {
        SendService.connectToKafka();
    }

    @GetMapping("/kafka")
    public String produce(@RequestParam("message") String message) {
        try {
            SendService.sendMessage(message);
            return "Sent to Consumer";
        } catch (Exception e) {
            return "Unexpected Error";
        }
    }

    @GetMapping("/kafka/messages")
    public List<String> getMessages() {
        return TestConsumer.receiveMessage();
    }

}