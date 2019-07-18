package com.lambdaschool.orders.repos;

import com.lambdaschool.orders.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface Customerrepo extends CrudRepository<Customer, Long>
{
    Customer findByName(String name);
}
