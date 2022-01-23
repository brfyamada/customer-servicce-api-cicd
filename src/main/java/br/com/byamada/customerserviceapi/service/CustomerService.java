package br.com.byamada.customerserviceapi.service;

import br.com.byamada.customerserviceapi.model.Customer;
import br.com.byamada.customerserviceapi.request.CustomerPostRequest;
import br.com.byamada.customerserviceapi.request.CustomerPutRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    Customer getCustomerById(Long id);
    Page<Customer> getCustomer(Pageable pageable);
    Long save(CustomerPostRequest customer);
    void update(Long customerID, CustomerPutRequest customer);
}
