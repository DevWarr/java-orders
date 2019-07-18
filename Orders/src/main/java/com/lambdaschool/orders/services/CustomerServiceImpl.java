package com.lambdaschool.orders.services;

import com.lambdaschool.orders.repos.Customerrepo;
import com.lambdaschool.orders.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
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

    @Transactional
    @Override
    public Customer save(Customer customer)
    {
        Customer c = new Customer();

        c.setName(customer.getName());
        c.setAgent(customer.getAgent());
        c.setCity(customer.getCity());
        c.setCountry(customer.getCountry());
        c.setGrade(customer.getGrade());
        c.setOpeningAmt(customer.getOpeningAmt());
        c.setOutstandingAmt(customer.getOutstandingAmt());
        c.setPaymentAmt(customer.getPaymentAmt());
        c.setPhone(customer.getPhone());
        c.setReceiveAmt(customer.getReceiveAmt());
        c.setWorkingArea(customer.getWorkingArea());

//        for (Orders o : customer.getOrders())
//        {
//            c.getOrders().add(new Orders(o.getOrderAmt(), o.getAdvanceAmt(), o.getCustomer(), o.getOrderDescription()));
//        }

        return custRepo.save(c);
    }

    @Transactional
    @Override
    public Customer update(Customer customer, long id)
    {
        return null;
    }
}