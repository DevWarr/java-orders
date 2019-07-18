package com.lambdaschool.orders.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Orders
{
    // Fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderNum;

    private double orderAmt;
    private double advanceAmt;
    private String orderDescription;

    @ManyToOne
    @JoinColumn(name = "customerCode",
                nullable = false)
    @JsonIgnoreProperties("orders")
    private Customer customer;

    // Constructor
    public Orders()
    {}

    public Orders(double orderAmt, double advanceAmt, Customer customer, String orderDescription) {
        this.orderAmt = orderAmt;
        this.advanceAmt = advanceAmt;
        this.orderDescription = orderDescription;
        this.customer = customer;
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

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
