package com.example.shop.customer;

import org.springframework.data.repository.Repository;

import java.util.List;

public interface CustomerRepository extends Repository<Customer, Long> {
  List<Customer> findAll();

  Customer save(Customer customer);

  Customer findById(Long id);

  Customer findByLogin(String Login);
}

