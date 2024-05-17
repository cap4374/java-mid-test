package com.mid.example.javamidtest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository 
    extends JpaRepository<Customer, Integer> {   
    
    // @Query("select firstName, lastName, companyName, emailAddress from Customer where customerId = ?1")
    // public Customer findByCustomerId(Integer customerId);
    // @Query("select firstName, lastName, companyName, emailAddress from Customer where emailAddress = ?1")
    // public Customer findByEmailAddress(String emailAddress);
}  