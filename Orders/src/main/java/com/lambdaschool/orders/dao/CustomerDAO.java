package com.lambdaschool.orders.dao;

import com.lambdaschool.orders.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerDAO extends CrudRepository<Customer, Long>
{
}
