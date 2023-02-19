package com.task.demo.service;

import com.task.demo.requests.RequestDTO;
import com.task.demo.requests.RespReqDTO;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PaymentMethodService {
    public ResponseEntity<RespReqDTO> getRecords();
    public ResponseEntity <RespReqDTO> getRecords(int id);
    public ResponseEntity <RespReqDTO> getRecords(String name);
    public ResponseEntity<String> saveAll(RespReqDTO resp);
    public ResponseEntity<String> update( RespReqDTO respReqDTO,int id);
}
