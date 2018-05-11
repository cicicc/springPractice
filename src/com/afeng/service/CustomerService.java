package com.afeng.service;

import com.afeng.domain.Customer;

import java.util.List;

public interface CustomerService {
    void save(Customer customer);

    List<Customer> findAll();
}
