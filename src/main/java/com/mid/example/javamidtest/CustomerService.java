package com.mid.example.javamidtest;

import java.util.List;

public interface CustomerService {   
    public List<Customer> getAllCustomers();
    public Customer getCustomer(Integer id);
    // public Customer getCustomer(Integer customerId);
    // public Customer getCustomerByEmail(String email);
}
