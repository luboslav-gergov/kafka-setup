package org.example;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class Consumer {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.setProperty("group.id", "lubaka_test_3");

        props.setProperty("auto.offset.reset", "earliest");        // Start from beginning if no offset
//        props.setProperty("enable.auto.commit", "true");           // Auto commit offsets

        try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props)) {
            consumer.subscribe(Collections.singletonList("Three-partitions"));

            System.out.println("Consumer started...");

            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
                for (ConsumerRecord<String, String> record : records) {
                    System.out.printf("Consumed record: topic=%s partition=%d offset=%d key=%s value=%s%n",
                            record.topic(), record.partition(), record.offset(), record.key(), record.value());
                }
            }
        }
    }
}


