package com.mid.example.javamidtest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder 
@Table(name = "Customer", schema = "SalesLT")
public class Customer {
    @Id
    @Column(name = "customerid")
    private int CustomerId;
    @Column(name = "firstname")
    private String FirstName;
    @Column(name = "lastname")
    private String LastName;
    @Column(name = "companyname")
    private String companyName;
    @Column(name = "emailaddress")
    private String emailAddress;
}
