package br.com.byamada.customerserviceapi.controller;

import br.com.byamada.customerserviceapi.mock.CustomerCreator;
import br.com.byamada.customerserviceapi.mock.CustomerPostRequestCreator;
import br.com.byamada.customerserviceapi.mock.CustomerPutRequestCreator;
import br.com.byamada.customerserviceapi.model.Customer;
import br.com.byamada.customerserviceapi.service.CustomerService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
class CustomerControllerTest {

    @InjectMocks
    private CustomerController customerController;

    @Mock
    private CustomerService customerService;

    @BeforeEach
    void setUp(){
        PageImpl<Customer> pageCst = new PageImpl<>(List.of(CustomerCreator.createValidCustomer()));
        BDDMockito.when(customerService.getCustomer(ArgumentMatchers.any()))
                .thenReturn(pageCst);
        BDDMockito.when(customerService.getCustomerById(ArgumentMatchers.any())).thenReturn(CustomerCreator.createValidCustomer());
        BDDMockito.when(customerService.save(ArgumentMatchers.any())).thenReturn(1L);
    }

    @Test
    @DisplayName("Test of get custumer returning a page of custumer")
    void getCustomersTest(){
        Customer expectedCustomer = CustomerCreator.createValidCustomer();
        ResponseEntity<Page<Customer>> response = customerController.getCustomers(null);

        Assertions.assertThat(response.getBody()).isNotNull();
        Assertions.assertThat(response.getBody().toList())
                .isNotEmpty()
                .hasSize(1);
        Assertions.assertThat(response.getBody().toList().get(0))
                .isEqualTo(expectedCustomer);
        Assertions.assertThat(response.getStatusCode())
                .isEqualTo(HttpStatus.OK);
    }

    @Test
    @DisplayName("Test get Customer by ID")
    void getCustomerByIdTest(){
        ResponseEntity<Customer> response = customerController.getCustomerById(1L);
        Assertions.assertThat(response.getBody()).isNotNull();
        Assertions.assertThat(response.getBody()).isEqualTo(CustomerCreator.createValidCustomer());
        Assertions.assertThat(response.getStatusCode())
                .isEqualTo(HttpStatus.OK);
    }

    @Test
    @DisplayName("Test of Post customer")
    void postCustomerTest(){
        ResponseEntity<Long> response = customerController.postCustomer(CustomerPostRequestCreator.customerPostRequestToBeSaved());
        Assertions.assertThat(response.getBody()).isEqualTo(1L);
        Assertions.assertThat(response.getStatusCode())
                .isEqualTo(HttpStatus.CREATED);
    }

    @Test
    @DisplayName("Test of Put customer")
    void putCustomerTest(){

        Assertions.assertThat(customerController.putCustomer(1L, CustomerPutRequestCreator.customerPutRequestToBeSaved()).getStatusCode())
                .isEqualTo(HttpStatus.NO_CONTENT);
    }





}