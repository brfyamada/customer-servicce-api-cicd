package br.com.byamada.customerserviceapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;

// [KAFKA - AVRO] [step 6] Necessary to add @EnableKafka annotation for kafka activate
@EnableKafka
//[FEIGN CLIENT] [Step 2] Adding @EnableFeignClients annotation to enable feign client
@EnableFeignClients
@EnableScheduling
@SpringBootApplication
public class CustomerServiceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApiApplication.class, args);
	}

}