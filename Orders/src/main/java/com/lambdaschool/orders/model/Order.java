package com.lambdaschool.orders.model;

import javax.persistence.*;
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
    private String orderDescription;

    @ManyToOne
    @JoinColumn(name = "customerCode",
                nullable = false)
    private Customer customer;

    // Constructor
    public Order()
    {}

    public Order(double orderAmt, double advanceAmt, String orderDescription, Customer customer) {
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
}
