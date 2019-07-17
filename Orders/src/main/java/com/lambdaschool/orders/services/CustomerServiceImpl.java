package com.lambdaschool.orders.services;

import com.lambdaschool.orders.repos.Customerrepo;
import com.lambdaschool.orders.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService
{
    @Autowired
    private Customerrepo custRepo;

    @Override
    public List<Customer> findAll()
    {
        List<Customer> list = new ArrayList<>();
        custRepo.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Customer findCustomerByCode(long code)
    {
        return custRepo.findById(code).orElseThrow(() -> new EntityNotFoundException(Long.toString(code)));
    }

    @Override
    public Customer findCustomerByName(String name)
    {
        Customer c = custRepo.findByName(name);

        if (c == null)
        {
            throw new EntityNotFoundException("Customer " + name + " not found!");
        }

        return c;
    }

    @Override
    public void delete(long code)
    {

    }

    @Override
    public Customer save(Customer customer)
    {
        return null;
    }

    @Override
    public Customer update(Customer customer, long id)
    {
        return null;
    }
}
