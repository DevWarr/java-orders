package com.lambdaschool.orders.controllers;

import com.lambdaschool.orders.model.Customer;
import com.lambdaschool.orders.services.CustomerService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.net.URI;
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

    @PostMapping(value = "/new",
                 consumes = {"application/json"},
                 produces = {"application/json"})
    public ResponseEntity<?> postCustomer(@Valid
                                          @RequestBody Customer customer)
    {
        customer = customerService.save(customer);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newCustomerURI = ServletUriComponentsBuilder.fromCurrentRequest().replacePath("/name/{custname}").buildAndExpand(customer.getName()).toUri();
        responseHeaders.setLocation(newCustomerURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{custcode}",
                consumes = {"application/json"},
                produces = {"application/json"})
    public ResponseEntity<?> putCustomer(@RequestBody Customer customer, @PathVariable long custcode)
    {
        customerService.update(customer, custcode);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
