//[FEIGN CLIENT] [Step 4] Creating a config

package br.com.byamada.customerserviceapi.feign.config;

import br.com.byamada.customerserviceapi.feign.SecurityManagerClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Feign;
import feign.Logger;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;

@Slf4j
@RequiredArgsConstructor
public class SecurityManagerFeignConfig{

    private ObjectMapper mapper;

    @Value("${security-manager.url}")
    private String securityManagerUrl;

    @Value("${app.authentication-token}")
    private String appToken;

    @Bean("SecurityManagerClient")
    public SecurityManagerClient securityManagerClient() {
        return Feign.builder()
                .client(new OkHttpClient())
                .contract(new SpringMvcContract())
                .logLevel(Logger.Level.FULL)
                .logger(new Slf4jLogger())
                .encoder(new JacksonEncoder(mapper))
                .decoder(new JacksonDecoder(mapper))
                .requestInterceptor(securityManagerInterceptor())
                .target(SecurityManagerClient.class, securityManagerUrl);
    }

    //[FEIGN CLIENT] [Step 5] Creating a interceptor
    @Bean("securityManagerInterceptor")
    public RequestInterceptor securityManagerInterceptor() {
        return template -> {
            template.header("Content-Type", "application/json");
            template.header("X-App-Token", appToken);
            log.info("Making a call to Security Manager: " + template.feignTarget().url() + template.path());
        };
    }

}
