package com.task.demo.requests;

import java.util.ArrayList;
import java.util.List;

public class RequestDTO {
    private String name;
    private String displayName;
    private String paymentType;
    private List<PaymentPlanDTO> paymentPlans=new ArrayList<PaymentPlanDTO>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public List<PaymentPlanDTO> getPaymentPlans() {
        return paymentPlans;
    }

    public void setPaymentPlans(List<PaymentPlanDTO> paymentPlans) {
        this.paymentPlans = paymentPlans;
    }
}
