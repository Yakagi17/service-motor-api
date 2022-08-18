package com.ist.servicemotorapi.spring.core.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.ist.servicemotorapi.spring.core.models.entities.ServiceMotorcycle;
import com.ist.servicemotorapi.spring.core.models.repos.ServiceMotorcycleRepo;
import com.ist.servicemotorapi.spring.core.response.ResponseHandler;
import com.ist.servicemotorapi.spring.core.helpers.DateFormater;
import com.ist.servicemotorapi.spring.core.helpers.EnumService;
import com.ist.servicemotorapi.spring.core.helpers.DataChecker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class ServiceMotorcycleService {
    
    @Autowired
    private ServiceMotorcycleRepo serviceMotorcycleRepo;

    public ResponseEntity<Object> save(ServiceMotorcycle serviceMotorcycle){
              
        if(serviceMotorcycle.getStatus()==null){
            serviceMotorcycle.setStatus("WAITING");
        } else if (!DataChecker.isContain(EnumService.status, serviceMotorcycle.getStatus())){
            return ResponseHandler.failedResponse(HttpStatus.BAD_REQUEST);
        }

        if (!DataChecker.isContain(EnumService.service_type, serviceMotorcycle.getService_type())){
            return ResponseHandler.failedResponse(HttpStatus.BAD_REQUEST);
        }
        
        serviceMotorcycle.setCreated_at(DateFormater.getCurrentDate());
        serviceMotorcycle.setCreated_by("SYSTEM");
        serviceMotorcycle.setIs_deleted(false);

        try{
            ServiceMotorcycle _serviceMotorcycle = serviceMotorcycleRepo.save(serviceMotorcycle);
            return ResponseHandler.successResponse(_serviceMotorcycle, HttpStatus.OK);
        } catch (Exception e){
            return ResponseHandler.failedResponse(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    public ResponseEntity<List<ServiceMotorcycle>> findByStatus(String status){
        List<ServiceMotorcycle> serviceMotorcycles = new ArrayList<ServiceMotorcycle>();

        if (!DataChecker.isContain(EnumService.status, status)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
        try {
            serviceMotorcycleRepo.findByStatus(status).forEach(serviceMotorcycles::add);
            
            if(serviceMotorcycles.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            
            return new ResponseEntity<>(serviceMotorcycles, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    public ResponseEntity<Object> updateStatus(Integer id, String status){

        try{
            Optional<ServiceMotorcycle> serviceMotorcycle = serviceMotorcycleRepo.findById(id);
            if(!serviceMotorcycle.isPresent()){
                return ResponseHandler.failedResponse(HttpStatus.NOT_FOUND);
            }
    
            ServiceMotorcycle _serviceMotorcycle = serviceMotorcycle.get();
    
            if (!DataChecker.isContain(EnumService.status, status)){
                return ResponseHandler.failedResponse(HttpStatus.BAD_REQUEST);
            }        
            
                _serviceMotorcycle.setStatus(status);
                _serviceMotorcycle.setUpdated_at(DateFormater.getCurrentDate());
            
            return ResponseHandler.successResponse(serviceMotorcycleRepo.save(_serviceMotorcycle), HttpStatus.OK);
        } catch (Exception e) {
			return ResponseHandler.failedResponse(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }    

}
