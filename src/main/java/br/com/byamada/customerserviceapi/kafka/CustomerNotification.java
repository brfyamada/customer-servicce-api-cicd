// [KAFKA - AVRO] [step 10] Example of producing message
package br.com.byamada.customerserviceapi.kafka;


import br.com.byamada.customerserviceapi.avro.CustomerDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Component
public class CustomerNotification {

    private static final int EVERY_TEM_SECONDS = 10 * 1000;

    @Value(value = "${kafka.customer.topic}")
    private String customerTopic;

    @Qualifier("customerEventProducerTemplate")
    private final KafkaTemplate<String, CustomerDTO> customerEventProducerTemplate;

    //It's only an example of producer, in this case I'm using a scheduling to call every time
    //@Scheduled(fixedDelay = EVERY_TEM_SECONDS)
    public void createExampleOfProducer(){

        String id =  UUID.randomUUID().toString().replace("-", "");

        CustomerDTO cst = CustomerDTO.newBuilder()
                .setName("Example:" + id)
                .setDocument("9999999999")
                .setAge(55)
                .build();

        customerEventProducerTemplate.send(customerTopic, id, cst)
                .addCallback(result -> log.info("Success posting customer to topic"), ex -> log.error("Error posting customer to topic") );

        System.out.println("Customer Postado:  " + cst.getName() );
    }
}
