package br.com.byamada.customerserviceapi.service.Impl;

import br.com.byamada.customerserviceapi.exception.BadRequestException;
import br.com.byamada.customerserviceapi.mapper.CustomerMapper;
import br.com.byamada.customerserviceapi.model.Customer;
import br.com.byamada.customerserviceapi.repository.CustomerRepository;
import br.com.byamada.customerserviceapi.request.CustomerPostRequest;
import br.com.byamada.customerserviceapi.request.CustomerPutRequest;
import br.com.byamada.customerserviceapi.service.CustomerService;
import br.com.byamada.customerserviceapi.util.SlackAlertSender;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Customer getCustomerById(Long id) {
        try {
            return customerRepository.findById(id).orElseThrow(() -> new BadRequestException( "Customer Not Found"));
        } catch (BadRequestException ex){
            //[SLACK] [step 4] mandando alerta para o slack
            SlackAlertSender.sendAlert("Customer Not Found, id: " + id);
            throw ex;
        }
    }

    @Override
    public Page<Customer> getCustomer(Pageable pageable) {
        return customerRepository.findAll(pageable) ;
    }

    @Transactional
    @Override
    public Long save(CustomerPostRequest customer) {
        Customer cst = CustomerMapper.INSTANCE.toCustomer(customer);
        cst.setCreationDate(new Date());
        return customerRepository.save(cst).getCustomerId();
    }

    @Transactional
    @Override
    public void update(Long customerId, CustomerPutRequest customer) {
        if(!customerId.equals(customer.getCustomerId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"The path id and entity id not matches");
        }
        Customer cstFinded = this.getCustomerById(customerId);
        Customer cst = CustomerMapper.INSTANCE.toCustomer(customer);
        cst.setCustomerId(cstFinded.getCustomerId());
        customerRepository.save(cst);
    }
}
