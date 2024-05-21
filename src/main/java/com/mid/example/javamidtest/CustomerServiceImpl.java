package com.mid.example.javamidtest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Slf4j 
@Service 
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        log.debug("RHYMOND:: getAllCustomers ");
        customerRepository.findAll();
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public Customer getCustomer(Integer id) {
        log.debug("RHYMOND:: getCustomer : " + id);
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.get();
    }

    // @Override
    // public Customer getCustomer(Integer id) {
    //     return customerRepository.findByCustomerId(id);
    // }    

    // @Override
    // public Customer getCustomerByEmail(String email) {
    //     return customerRepository.findByEmailAddress(email);
    // }
}
