package br.com.byamada.customerserviceapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@Entity
@Table(name = "CUSTOMER")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idt_customer_id")
    private Long customerId;

    @Column(name = "des_name")
    @NotEmpty
    private String name;

    @Column(name = "num_document")
    private String document;

    @Column(name = "num_age")
    private int age;

    @Column(name = "dat_creation")
    private Date creationDate;

    @Column(name = "dat_update")
    private Date updateDate;

    @Column(name = "des_user_operation")
    private String userOperation;

}
