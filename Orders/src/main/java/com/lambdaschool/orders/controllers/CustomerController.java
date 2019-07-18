package com.lambdaschool.orders.controllers;

import com.lambdaschool.orders.model.Customer;
import com.lambdaschool.orders.services.CustomerService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController
{
    @Autowired
    CustomerService customerService;

    @GetMapping(value = "/order",
                produces = {"application/json"})
    public ResponseEntity<?> getAllCustomers()
    {
        List<Customer> list = customerService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/name/{custname}",
                produces = {"application/json"})
    public ResponseEntity<?> getCustomerByName(@PathVariable String custname)
    {
        Customer c = customerService.findCustomerByName(custname);
        if (c == null)
        {
            throw new EntityNotFoundException(custname);
        }
        return new ResponseEntity<>(c, HttpStatus.OK);
    }
}
