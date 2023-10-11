package com.okta.javakafka.configuration;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class SendService {

    private static KafkaProducer<String, String> producer;

    private static ProducerRecord<String, String> record;

    private static Properties properties;

    public static void connectToKafka() {
        String bservers = "192.168.56.2:9092";
        properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bservers);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
    }

    public static void sendMessage(String message) {
        producer = new KafkaProducer<>(properties);
        record = new ProducerRecord<>("myTopic", message);
        producer.send(record);
        producer.flush();
        producer.close();
    }
}
