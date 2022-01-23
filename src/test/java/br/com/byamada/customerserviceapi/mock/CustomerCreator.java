package br.com.byamada.customerserviceapi.mock;

import br.com.byamada.customerserviceapi.model.Customer;

public class CustomerCreator {

    public static Customer createCustomerToBeSaved(){
        return Customer.builder()
                .name("João Paulo")
                .document("123456789")
                .userOperation("Test Junit")
                .age(27)
                .build();
    }

    public static Customer createValidCustomer(){
        return Customer.builder()
                .customerId(1L)
                .name("Carlos da Cunha")
                .document("123456789")
                .userOperation("Test Junit")
                .age(30)
                .build();
    }


    public static Customer createCustomerTobeUpdated(){
        return Customer.builder()
                .customerId(1L)
                .name("João Paulo")
                .document("123456789")
                .userOperation("Test Junit")
                .age(27)
                .build();
    }


}
