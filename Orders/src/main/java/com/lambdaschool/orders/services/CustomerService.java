package com.lambdaschool.orders.services;

import com.lambdaschool.orders.model.Customer;

import java.util.List;

public interface CustomerService
{
    List<Customer> findAll();

    Customer findCustomerByCode(long code);

    Customer findCustomerByName(String name);

    void delete(long code);

    Customer save(Customer customer);

    Customer update(Customer customer, long id);
}
