package com.task.demo.requests;

import java.util.ArrayList;
import java.util.List;

public class RespReqDTO {
    List<RequestDTO> paymentMethod=new ArrayList<>();

    public List<RequestDTO> getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(List<RequestDTO> paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
