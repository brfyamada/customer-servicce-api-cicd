package br.com.byamada.customerserviceapi.controller;

import br.com.byamada.customerserviceapi.model.Customer;
import br.com.byamada.customerserviceapi.request.CustomerPostRequest;
import br.com.byamada.customerserviceapi.request.CustomerPutRequest;
import br.com.byamada.customerserviceapi.service.CustomerService;
import io.micrometer.core.annotation.Counted;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    /* [METRICS] [Opção 2] Utilizando MeterRegister para registrar o counter*/
    private final MeterRegistry meterRegistry;

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("customerId") Long customerId){
        /* [METRICS] [Opção 2] registrando o counter e realizando a contagem por incremento
        Counter.builder("counted_get_customer_by_id")
                .description("GetCustomerByIdCounter")
                .tag("customerId", customerId.toString())
                .register(meterRegistry)
                .increment(1);

         */
        return ResponseEntity.ok(customerService.getCustomerById(customerId));
    }


    @GetMapping
    /* [METRICS] [Opção 1] Adicinando um @Counter para fazer contagem de requisições com anotação*/
    @Counted(value = "counted_get_customers",description = "GetCustomersCounter")
    public ResponseEntity<Page<Customer>> getCustomers(Pageable pageable){
        return ResponseEntity.ok(customerService.getCustomer(pageable));
    }

    @PostMapping
    /* [METRICS] [Opção 1] Adicinando um @Counter para fazer contagem de requisições com anotação*/
    @Counted(value = "counted_post_customers",description = "PostCustomersCounter")
    public ResponseEntity<Long> postCustomer(@RequestBody @Valid CustomerPostRequest customer) {
        return new ResponseEntity<>(customerService.save(customer), HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    /* [METRICS] [Opção 1] Adicinando um @Counter para fazer contagem de requisições com anotação*/
    @Counted(value = "counted_put_customers",description = "PutCustomerCounter")
    public ResponseEntity<Void> putCustomer(@PathVariable("customerId") Long customerId ,@RequestBody @Valid CustomerPutRequest customer) {
        customerService.update(customerId, customer);
        return ResponseEntity.noContent().build();
    }


}
