package com.mid.example.javamidtest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@Slf4j
public class CustomerController {

    // private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);	
    
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getCustomerList(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable("id") Integer id){
        log.debug("RHYMOND:: getCustomer");	
        return customerService.getCustomer(id);
    }    

    // @GetMapping("/customers/{email}")
    // public Customer getCustomerByEmail(@PathVariable("email") String email){
    //     return customerService.getCustomerByEmail(email);
    // }      
}
