// [KAFKA - AVRO] [step 9] Configuration for KafkaProducer
package br.com.byamada.customerserviceapi.kafka;

import br.com.byamada.customerserviceapi.avro.CustomerDTO;
import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProcucerConfig {

    @Value(value = "${kafka.broker-url}")
    private String brokerUrls;

    @Value(value = "${kafka.schema-registry.url}")
    private String schemaRegistry;

    @Bean("customerEventProducerTemplate")
    public KafkaTemplate<String, CustomerDTO> customerEventProducerTemplate() {
        return new KafkaTemplate<>(new DefaultKafkaProducerFactory<>(createAvroProperties()));
    }

    private Map<String, Object> createAvroProperties(){
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerUrls);
        props.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, schemaRegistry);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
        props.put(ProducerConfig.RETRIES_CONFIG, Integer.MAX_VALUE);
        props.put(ProducerConfig.ACKS_CONFIG,"1");
        props.put(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION, 1);
        return props;
    }
}
