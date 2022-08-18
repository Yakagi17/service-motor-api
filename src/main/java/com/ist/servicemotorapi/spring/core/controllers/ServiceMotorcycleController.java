package com.ist.servicemotorapi.spring.core.controllers;

import java.util.List;

import com.ist.servicemotorapi.spring.core.models.entities.ServiceMotorcycle;
import com.ist.servicemotorapi.spring.core.services.ServiceMotorcycleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/service")
public class ServiceMotorcycleController {
    
    @Autowired
    private ServiceMotorcycleService serviceMotorcycleService;

    @PostMapping
    public ResponseEntity<Object> createOrder(@RequestBody ServiceMotorcycle serviceMotorcycle){
        return serviceMotorcycleService.save(serviceMotorcycle);
    }

    @GetMapping
    public ResponseEntity<List <ServiceMotorcycle>> getAllOrder(@RequestParam String status){
        return serviceMotorcycleService.findByStatus(status);
    }

    @PutMapping("/{id}/update-status")
    public ResponseEntity<Object> updateStatus(@PathVariable("id") Integer id, @RequestParam String status){
        return serviceMotorcycleService.updateStatus(id, status);
    }
}
