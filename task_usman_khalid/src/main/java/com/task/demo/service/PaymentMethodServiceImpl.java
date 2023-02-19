package com.task.demo.service;

import com.task.demo.model.PaymentMethodEntity;
import com.task.demo.repository.PaymentMethodRepository;
import com.task.demo.requests.PaymentPlanDTO;
import com.task.demo.requests.RequestDTO;
import com.task.demo.requests.RespReqDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sun.reflect.annotation.ExceptionProxy;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class PaymentMethodServiceImpl implements PaymentMethodService{
    @Autowired
    private PaymentMethodRepository paymentMethodRepository;
    @Override
    public ResponseEntity<RespReqDTO> getRecords() {
        ResponseEntity<RespReqDTO> resp=null;
        try{
        List<PaymentMethodEntity> paymentMethodEntities=paymentMethodRepository.findAll();
        RespReqDTO response= new RespReqDTO();
        if(paymentMethodEntities.size()>0){
            response.getPaymentMethod().addAll(mapEntityToRequest(paymentMethodEntities));
            resp=new ResponseEntity<>(response,HttpStatus.OK);
            return resp;
        }else{
            resp=new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return resp;
        }
        }catch (Exception e){
            e.printStackTrace();
            resp=new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            return resp;
        }
    }
    public ResponseEntity <RespReqDTO> getRecords(int id){
        ResponseEntity<RespReqDTO> resp=null;
        List<PaymentMethodEntity> paymentMethodEntities=new ArrayList<>();
        RespReqDTO response= new RespReqDTO();
        try{
            PaymentMethodEntity paymentMethodEntity =paymentMethodRepository.findById(id);
            if(paymentMethodEntity!=null){
                paymentMethodEntities.add(paymentMethodEntity);
                response.getPaymentMethod().addAll(mapEntityToRequest(paymentMethodEntities));
                resp=new ResponseEntity<>(response,HttpStatus.OK);
                return resp;
            }else{
                resp=new ResponseEntity<>(HttpStatus.NO_CONTENT);
                return resp;
            }
        }catch (Exception e){
            e.printStackTrace();
            resp=new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            return resp;
        }



    }
    public ResponseEntity<String> saveAll(RespReqDTO resp){
        try {
            List saveAllDtos =!resp.getPaymentMethod().isEmpty()? mapRequestToEntity(resp.getPaymentMethod()):null;
            if(saveAllDtos!=null) {
                paymentMethodRepository.saveAll(saveAllDtos);
                return new ResponseEntity<>("Success",HttpStatus.OK);
            }else{
                return new ResponseEntity<>("No Record Entered",HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Issue in inserting in db",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity <RespReqDTO> getRecords(String name){
        ResponseEntity<RespReqDTO> resp=null;
        List<PaymentMethodEntity> paymentMethodEntities;
        RespReqDTO response= new RespReqDTO();
        try{
            paymentMethodEntities =paymentMethodRepository.findByName(name);
            if(!paymentMethodEntities.isEmpty()){
                response.getPaymentMethod().addAll(mapEntityToRequest(paymentMethodEntities));
                resp=new ResponseEntity<>(response,HttpStatus.OK);
                return resp;
            }else{
                resp=new ResponseEntity<>(HttpStatus.NO_CONTENT);
                return resp;
            }
        }catch (Exception e){
            e.printStackTrace();
            resp=new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            return resp;
        }



    }
    public ResponseEntity<String> update (RespReqDTO respReqDTO,int id){
        PaymentMethodEntity paymentMethodEntity =paymentMethodRepository.findById(id);
        try {
            if (paymentMethodEntity != null) {
                respReqDTO.getPaymentMethod().forEach((requestDTO) -> {
                    requestDTO.getPaymentPlans().forEach((paymentPlanDTO) -> {
                        if (id == paymentPlanDTO.getId()) {
                            paymentMethodEntity.setName(requestDTO.getName());
                            paymentMethodEntity.setDispalyName(requestDTO.getDisplayName());
                            paymentMethodEntity.setPaymentType(requestDTO.getPaymentType());
                            paymentMethodEntity.setDuration(paymentPlanDTO.getDuration());
                            paymentMethodEntity.setNetAmmount(paymentPlanDTO.getNetAmmount());
                            paymentMethodEntity.setGrossAmmount(paymentPlanDTO.getGrossAmmount());
                            paymentMethodEntity.setCurrency(paymentPlanDTO.getCurrency());
                            paymentMethodEntity.setTaxAmmount(paymentPlanDTO.getTaxAmmount());
                            paymentMethodRepository.save(paymentMethodEntity);
                        }
                    });

                });
                return new ResponseEntity<>("update successful",HttpStatus.OK);
            } else {
                return new ResponseEntity<>( HttpStatus.NO_CONTENT);
            }
        } catch(Exception e){
            e.printStackTrace();
            return  new ResponseEntity<>("internal server error",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    private List<RequestDTO> mapEntityToRequest(List<PaymentMethodEntity> paymentMethodEntities){
        Map paymentMethodIndexMap=new HashMap<String,Integer>();
        List<RequestDTO> requestDTOS=new ArrayList<RequestDTO>();
        int indexReq=0;
        for (int i=0;i<paymentMethodEntities.size();i++) {
            if (paymentMethodIndexMap.containsKey(paymentMethodEntities.get(i).getName())) {
                PaymentPlanDTO paymentPlanDTO=new PaymentPlanDTO();
                paymentPlanDTO.setId(paymentMethodEntities.get(i).getId());
                paymentPlanDTO.setCurrency(paymentMethodEntities.get(i).getCurrency());
                paymentPlanDTO.setDuration(paymentMethodEntities.get(i).getDuration());
                paymentPlanDTO.setGrossAmmount(paymentMethodEntities.get(i).getGrossAmmount());
                paymentPlanDTO.setNetAmmount(paymentMethodEntities.get(i).getNetAmmount());
                paymentPlanDTO.setTaxAmmount(paymentMethodEntities.get(i).getNetAmmount());
                requestDTOS.get((Integer) paymentMethodIndexMap.get(paymentMethodEntities.get(i).getName())).getPaymentPlans().add(paymentPlanDTO);


            } else {

                paymentMethodIndexMap.put(paymentMethodEntities.get(i).getName(), indexReq);
                indexReq++;
                RequestDTO reqItem = new RequestDTO();
                reqItem.setName(paymentMethodEntities.get(i).getName());
                reqItem.setDisplayName(paymentMethodEntities.get(i).getDispalyName());
                reqItem.setPaymentType(paymentMethodEntities.get(i).getPaymentType());
                PaymentPlanDTO paymentPlanDTO=new PaymentPlanDTO();
                paymentPlanDTO.setId(paymentMethodEntities.get(i).getId());
                paymentPlanDTO.setCurrency(paymentMethodEntities.get(i).getCurrency());
                paymentPlanDTO.setDuration(paymentMethodEntities.get(i).getDuration());
                paymentPlanDTO.setGrossAmmount(paymentMethodEntities.get(i).getGrossAmmount());
                paymentPlanDTO.setNetAmmount(paymentMethodEntities.get(i).getNetAmmount());
                paymentPlanDTO.setTaxAmmount(paymentMethodEntities.get(i).getNetAmmount());
                reqItem.getPaymentPlans().add(paymentPlanDTO);
                requestDTOS.add(reqItem);
            }

        }
        return requestDTOS;
    }
    private List<PaymentMethodEntity> mapRequestToEntity(List<RequestDTO> req) {
        List<PaymentMethodEntity> paymentMethodEntityList= new ArrayList<>();
        req.forEach((reqItem)->{
            reqItem.getPaymentPlans().forEach((methodItem)->{
                PaymentMethodEntity paymentMethodEntity= new PaymentMethodEntity();
                paymentMethodEntity.setName(reqItem.getName());
                paymentMethodEntity.setDispalyName(reqItem.getDisplayName());
                paymentMethodEntity.setPaymentType(reqItem.getPaymentType());
                paymentMethodEntity.setNetAmmount(methodItem.getNetAmmount());
                paymentMethodEntity.setTaxAmmount(methodItem.getTaxAmmount());
                paymentMethodEntity.setGrossAmmount(methodItem.getGrossAmmount());
                paymentMethodEntity.setCurrency(methodItem.getCurrency());
                paymentMethodEntity.setDuration(methodItem.getCurrency());
                paymentMethodEntityList.add(paymentMethodEntity);
            });


        });
       return paymentMethodEntityList;
    }
}
