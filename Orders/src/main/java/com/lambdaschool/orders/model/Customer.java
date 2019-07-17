package com.lambdaschool.orders.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customerCode;

    @Column(nullable = false)
    private String name;

    private String city;
    private String workingArea;
    private String country;
    private String grade;
    private double openingAmt;
    private double receiveAmt;
    private double paymentAmt;
    private double outstandingAmt;
    private String phone;
    private List<Agent> agentCodes = new ArrayList<>();

    public Customer()
    {}

    public Customer(String name, String city, String workingArea, String country, String grade, double openingAmt, double receiveAmt, double paymentAmt, double outstandingAmt, String phone)
    {
        this.name = name;
        this.city = city;
        this.workingArea = workingArea;
        this.country = country;
        this.grade = grade;
        this.openingAmt = openingAmt;
        this.receiveAmt = receiveAmt;
        this.paymentAmt = paymentAmt;
        this.outstandingAmt = outstandingAmt;
        this.phone = phone;
    }

    public long getCustomerCode() {
        return customerCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getWorkingArea() {
        return workingArea;
    }

    public void setWorkingArea(String workingArea) {
        this.workingArea = workingArea;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getOpeningAmt() {
        return openingAmt;
    }

    public void setOpeningAmt(double openingAmt) {
        this.openingAmt = openingAmt;
    }

    public double getReceiveAmt() {
        return receiveAmt;
    }

    public void setReceiveAmt(double receiveAmt) {
        this.receiveAmt = receiveAmt;
    }

    public double getPaymentAmt() {
        return paymentAmt;
    }

    public void setPaymentAmt(double paymentAmt) {
        this.paymentAmt = paymentAmt;
    }

    public double getOutstandingAmt() {
        return outstandingAmt;
    }

    public void setOutstandingAmt(double outstandingAmt) {
        this.outstandingAmt = outstandingAmt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Agent> getAgentCodes() {
        return agentCodes;
    }

    public void setAgentCodes(List<Agent> agentCodes) {
        this.agentCodes = agentCodes;
    }
}
