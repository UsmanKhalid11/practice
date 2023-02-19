package com.task.demo.requests;

public class PaymentPlanDTO {
    private int id;
    private double netAmmount;
    private double taxAmmount;
    private double grossAmmount;
    private  String currency;
    private String duration;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getNetAmmount() {
        return netAmmount;
    }

    public void setNetAmmount(double netAmmount) {
        this.netAmmount = netAmmount;
    }

    public double getTaxAmmount() {
        return taxAmmount;
    }

    public void setTaxAmmount(double taxAmmount) {
        this.taxAmmount = taxAmmount;
    }

    public double getGrossAmmount() {
        return grossAmmount;
    }

    public void setGrossAmmount(double grossAmmount) {
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
}
