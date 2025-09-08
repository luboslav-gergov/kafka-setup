package org.example;

import java.util.Properties;
import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

public class Producer {

    public static void main(String[] args) {
        //Could move them into application.properties, but its fine for now
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        ProducerRecord<String, String> record = new ProducerRecord<>("Three-partitions", "key3", "consumer-test");
        Future<RecordMetadata> future = producer.send(record, ((recordMetadata, exception) -> {
            if (exception == null) {
                System.out.printf("Message sent successfully to topic=%s partition=%d offset=%d%n",
                        recordMetadata.topic(), recordMetadata.partition(), recordMetadata.offset());
            } else {
                System.err.println("Error sending message: " + exception.getMessage());
            }
        }));

//        RecordMetadata metadata = future.get(); // wait for the send to complete
//        System.out.println("Message sent to topic: " + metadata.topic() + ", partition: " + metadata.partition());

        producer.close();
    }
}