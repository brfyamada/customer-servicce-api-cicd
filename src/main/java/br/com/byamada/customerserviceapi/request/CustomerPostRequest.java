package br.com.byamada.customerserviceapi.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class CustomerPostRequest {

    @NotEmpty
    private String name;

    @NotEmpty
    private String document;

    private int age;
}
