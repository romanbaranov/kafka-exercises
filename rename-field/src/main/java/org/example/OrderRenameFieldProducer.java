package org.example;

import io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig;
import org.apache.kafka.clients.producer.*;
import org.jetbrains.annotations.NotNull;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class OrderRenameFieldProducer {

    public static final String APP_PROPERTIES = "app.properties";

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        Properties props = getProperties(ClassLoader.getSystemResource(APP_PROPERTIES));

        Producer<String, Order> producer = new KafkaProducer<>(props);

        String topic = "orders";
        String key = generateKey(); // run app several times without cleaning env

        Set<Order> orders = new HashSet<>();
        orders.add(new Order("order1", "cid23", "Hill Cli"));
        orders.add(new Order("order2", "cid24", "Michael Scofield"));
        orders.add(new Order("order3", "cid2", "Rick Grimes"));
        orders.add(new Order("order4", "cid2", "Maggie Rhee"));
        orders.add(new Order("order5", "cid235", "Daryl Dixon"));

        for (Order order : orders) {
            ProducerRecord<String, Order> record = new ProducerRecord<>(topic, key, order);
            Future<RecordMetadata> response = producer.send(record, (metadata, exception) -> {
                if (exception != null) {
                    exception.printStackTrace();
                } else {
                    System.out.println("Sent message with metadata: " + metadata);
                }
            });
            response.get();
            System.out.println("Produced data: " + key + "=" + order);
        }

        producer.flush();
        producer.close();
    }

    private static @NotNull String generateKey() {
        return "order-key-" + (int) ((Math.random() * 100) + 100);
    }

    private static @NotNull Properties getProperties(URL appProperties) throws IOException {
        Properties props = new Properties();
        props.load(new FileInputStream(appProperties.getFile()));
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, props.getProperty("bootstrap.servers.config"));
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, props.getProperty("key.serializer.class.config"));
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, props.getProperty("value.serializer.class.config"));
        props.put(AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, props.getProperty("schema.registry.url.config"));

        return props;
    }

}