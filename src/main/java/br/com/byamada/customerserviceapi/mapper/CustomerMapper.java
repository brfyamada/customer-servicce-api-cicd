package br.com.byamada.customerserviceapi.mapper;

import br.com.byamada.customerserviceapi.model.Customer;
import br.com.byamada.customerserviceapi.request.CustomerPostRequest;
import br.com.byamada.customerserviceapi.request.CustomerPutRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class CustomerMapper {
    public static final CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    public abstract Customer toCustomer(CustomerPostRequest customerPostRequest);
    public abstract Customer toCustomer(CustomerPutRequest customerPutRequest);
}
