package br.com.byamada.customerserviceapi.repository;

import br.com.byamada.customerserviceapi.mock.CustomerCreator;
import br.com.byamada.customerserviceapi.model.Customer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import javax.validation.ConstraintViolationException;
import java.util.Date;
import java.util.Optional;

@DataJpaTest
@DisplayName("Teste para Customer Repository")
@ActiveProfiles("test")
class CustomerRepositoryTest {


    @Autowired
    private CustomerRepository customerRepository;

    @Test
    @DisplayName("Save customer with success")
    void saveCustomer() {

        Customer cst = CustomerCreator.createCustomerToBeSaved();
        Customer cstSaved = customerRepository.save(cst);
        Assertions.assertThat(cstSaved).isNotNull();
        Assertions.assertThat(cstSaved.getCustomerId()).isNotNull();
        Assertions.assertThat(cstSaved.getName()).isEqualTo(cst.getName());

    }

    @Test
    @DisplayName("Save and Update customer")
    void saveAndUpdateCustomer() {
        Customer cstSaved = customerRepository.save(CustomerCreator.createCustomerToBeSaved());
        cstSaved.setName("Antônio Carlos");
        Customer cstUpdated = customerRepository.save(cstSaved);

        Assertions.assertThat(cstUpdated).isNotNull();
        Assertions.assertThat(cstUpdated.getCustomerId()).isEqualTo(cstSaved.getCustomerId());
        Assertions.assertThat(cstUpdated.getName()).isEqualTo(cstSaved.getName());
    }

    @Test
    @DisplayName("Save and Update customer")
    void saveAndDeleCustomer() {
        Customer cstSaved = customerRepository.save(CustomerCreator.createCustomerToBeSaved());
        customerRepository.delete(cstSaved);
        Optional<Customer> customerOptional = customerRepository.findById(cstSaved.getCustomerId());

        Assertions.assertThat(customerOptional.isEmpty()).isTrue();
    }

    @Test
    @DisplayName("Save When Throws Constraint Vioplation Execption")
    void saveWhenThrowsConstraintVioplationExecption() {
        Customer cstToBeSaved = new Customer();
        Assertions.assertThatThrownBy(() -> customerRepository.save(cstToBeSaved))
                .isInstanceOf(ConstraintViolationException.class);
    }


}