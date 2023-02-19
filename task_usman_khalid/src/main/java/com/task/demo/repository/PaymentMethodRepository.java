package com.task.demo.repository;

import com.task.demo.model.PaymentMethodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethodEntity, Integer> {
    public PaymentMethodEntity findById(int id);
    public List<PaymentMethodEntity> findByName(String Name);

}

