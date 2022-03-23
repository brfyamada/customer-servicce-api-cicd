// [KAFKA - AVRO] [step 8] Example of consuming message
package br.com.byamada.customerserviceapi.kafka;

import br.com.byamada.customerserviceapi.avro.CustomerDTO;
import br.com.byamada.customerserviceapi.request.CustomerPostRequest;
import br.com.byamada.customerserviceapi.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomerListener {

    private final CustomerService customerService;
/*
    @KafkaListener(
            containerFactory = "customerEventListenerFactory",
            topics = "${kafka.customer.topic}",
            groupId = "${kafka.customer.group-id}"
    )*/
    public void consume(CustomerDTO message){
        CustomerPostRequest cst = CustomerPostRequest.builder()
                .name(message.getName())
                .document(message.getDocument())
                .age(message.getAge())
                .build();
        customerService.save(cst);

        log.info(" *** Customer Saved from topic {}", cst.toString());
    }

}
