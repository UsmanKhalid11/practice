package com.task.demo.repository;

import com.task.demo.model.PaymentMethodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethodEntity, Integer> {
    public PaymentMethodEntity findById(int id);
    public List<PaymentMethodEntity> findByName(String Name);

    //to use search by specific field give that feild in param and use method findbyFeild i.e if you want to find by teacher use
    //findByTeacher(String teacher)

}

