package com.task.demo.model;

import javax.persistence.*;

@Entity
@Table(name="payment_methods")
public class PaymentMethodEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String dispalyName;
    private String paymentType;
    private Double netAmmount;
    private Double taxAmmount;
    private Double grossAmmount;
    private String currency;
    private String duration;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDispalyName() {
        return dispalyName;
    }

    public void setDispalyName(String dispalyName) {
        this.dispalyName = dispalyName;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Double getNetAmmount() {
        return netAmmount;
    }

    public void setNetAmmount(Double netAmmount) {
        this.netAmmount = netAmmount;
    }

    public Double getTaxAmmount() {
        return taxAmmount;
    }

    public void setTaxAmmount(Double taxAmmount) {
        this.taxAmmount = taxAmmount;
    }

    public Double getGrossAmmount() {
        return grossAmmount;
    }

    public void setGrossAmmount(Double grossAmmount) {
        this.grossAmmount = grossAmmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
    public PaymentMethodEntity(){

    }
    public PaymentMethodEntity(int id, String name, String dispalyName, String paymentType, Double netAmmount, Double taxAmmount, Double grossAmmount, String currency, String duration) {
        this.id = id;
        this.name = name;
        this.dispalyName = dispalyName;
        this.paymentType = paymentType;
        this.netAmmount = netAmmount;
        this.taxAmmount = taxAmmount;
        this.grossAmmount = grossAmmount;
        this.currency = currency;
        this.duration = duration;
    }
}
