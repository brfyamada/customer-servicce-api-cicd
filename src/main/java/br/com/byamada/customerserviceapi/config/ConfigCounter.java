/*
* [METRICS] [opção 1]
* Bean de configuração necessário para reconhecer a anotação @Counter
*/


package br.com.byamada.customerserviceapi.config;

import io.micrometer.core.aop.CountedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ConfigCounter {

        @Bean
        CountedAspect countedAspect(MeterRegistry registry) {
            return new CountedAspect(registry);
        }

}
