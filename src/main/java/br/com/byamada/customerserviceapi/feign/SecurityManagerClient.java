//[FEIGN CLIENT] [Step 3] Creating a Feign Client
package br.com.byamada.customerserviceapi.feign;

import br.com.byamada.customerserviceapi.feign.config.SecurityManagerFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;


@FeignClient(name = "securitymanager", url = "${security-manager.url}", configuration = SecurityManagerFeignConfig.class)
public interface SecurityManagerClient {

    @GetMapping(value = "/test/admin/test")
    Optional<String> adminTest();

}
