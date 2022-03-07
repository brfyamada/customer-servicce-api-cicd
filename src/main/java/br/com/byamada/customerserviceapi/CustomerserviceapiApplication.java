package br.com.byamada.customerserviceapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;

// [KAFKA - AVRO] [step 6] Necessary to add @EnableKafka annotation for kafka activate
@EnableKafka
@EnableScheduling
@SpringBootApplication
public class CustomerserviceapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerserviceapiApplication.class, args);
	}

}
