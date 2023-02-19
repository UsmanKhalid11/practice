package com.task.demo.controller;

import com.task.demo.requests.RespReqDTO;
import com.task.demo.service.PaymentMethodService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1.0/configueration")
public class PaymentPlanController {
    @Autowired
    private PaymentMethodService paymentMethodService;
    @ApiOperation(value="Find all payment methods." +
            "If you want to find against specific id add Id." +
            "If you want to find by name add name." +
            "Adding both will give bad request error")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 202, message = "No Content"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Server failure")
    })
    @GetMapping("/payment-methods")
    public ResponseEntity<?> getPaymentMethods(@RequestParam(value="id",required = false)String id,@RequestParam(value = "name",required = false)String name)  {
    if(id!=null && name!=null){
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
     if(id!=null){
        return paymentMethodService.getRecords(Integer.parseInt(id));
     } else if (name!=null) {
        return paymentMethodService.getRecords(name);

     }else{
         return paymentMethodService.getRecords();

     }
    }
    @ApiOperation(value="Enter all details for inseting data")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 202, message = "No Content"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Server failure")
    })
    @PostMapping("/payment-methods")
    public ResponseEntity<String> save(@RequestBody RespReqDTO reqDTO){
      return  paymentMethodService.saveAll(reqDTO);
    }
    @ApiOperation(value="Enter all details for updating data data make sure id in payment plans matches the given id ")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 202, message = "No Content"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Server failure")
    })
    @PutMapping("/payment-methods")
    public ResponseEntity<String> save(@RequestBody RespReqDTO reqDTO,@RequestParam("id") int id){
        return  paymentMethodService.update(reqDTO,id);
    }

}
