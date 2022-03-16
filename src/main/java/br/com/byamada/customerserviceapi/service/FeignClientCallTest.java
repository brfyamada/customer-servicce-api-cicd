//[FEIGN CLIENT] [Step 5] Creating an api integration test
package br.com.byamada.customerserviceapi.service;

import br.com.byamada.customerserviceapi.feign.SecurityManagerClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class FeignClientCallTest {

    private static final int EVERY_TEM_SECONDS = 10 * 1000;

    private final SecurityManagerClient securityManagerClient;

    @Scheduled(fixedDelay = EVERY_TEM_SECONDS)
    public void callSeviceManagerTest() {
        try{
            Optional<String> response = securityManagerClient.adminTest();
            System.out.println("Resposta do sececurity service: " + response.orElseThrow());
        }catch (Exception e){
            log.info("Erro na integração com o security manager service, Inicie o serviço");
        }
    }
}
