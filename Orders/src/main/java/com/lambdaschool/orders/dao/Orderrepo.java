package com.lambdaschool.orders.dao;

import com.lambdaschool.orders.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface Orderrepo extends CrudRepository<Order, Long>
{
}
