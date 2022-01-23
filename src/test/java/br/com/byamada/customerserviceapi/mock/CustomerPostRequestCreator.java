package br.com.byamada.customerserviceapi.mock;

import br.com.byamada.customerserviceapi.model.Customer;
import br.com.byamada.customerserviceapi.request.CustomerPostRequest;

public class CustomerPostRequestCreator {

    public static CustomerPostRequest customerPostRequestToBeSaved(){
        return CustomerPostRequest.builder()
                .name("João Paulo")
                .document("123456789")
                .age(27)
                .build();
    }
}
