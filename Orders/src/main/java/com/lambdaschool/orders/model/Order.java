package com.lambdaschool.orders.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "order")
public class Order
{
    // Fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderNum;

    private double orderAmt;
    private double advanceAmt;
    private List<Customer> customerCodes = new ArrayList<>();
    private String orderDescription;

    // Constructor
    public Order()
    {}

    public Order(double orderAmt, double advanceAmt, String orderDescription) {
        this.orderAmt = orderAmt;
        this.advanceAmt = advanceAmt;
        this.orderDescription = orderDescription;
    }

    // Getters and Setters

    public long getOrderNum() {
        return orderNum;
    }


    public double getOrderAmt() {
        return orderAmt;
    }

    public void setOrderAmt(double orderAmt) {
        this.orderAmt = orderAmt;
    }

    public double getAdvanceAmt() {
        return advanceAmt;
    }

    public void setAdvanceAmt(double advanceAmt) {
        this.advanceAmt = advanceAmt;
    }

    public List<Customer> getCustomerCodes() {
        return customerCodes;
    }

    public void setCustomerCodes(List<Customer> customerCodes) {
        this.customerCodes = customerCodes;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }
}
