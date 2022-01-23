package br.com.byamada.customerserviceapi.mock;

import br.com.byamada.customerserviceapi.request.CustomerPostRequest;
import br.com.byamada.customerserviceapi.request.CustomerPutRequest;

public class CustomerPutRequestCreator {

    public static CustomerPutRequest customerPutRequestToBeSaved(){
        return CustomerPutRequest.builder()
                .customerId(1L)
                .name("Paulo Santana")
                .document("123456789")
                .age(27)
                .build();
    }
}
