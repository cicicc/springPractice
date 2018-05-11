package com.afeng.dao;

import com.afeng.domain.Customer;

import java.util.List;

public interface CustomerDao {
    void save(Customer customer);

    List<Customer> findAll();

}
