package com.ist.servicemotorapi.spring.core.response;

import java.util.HashMap;
import java.util.Map;

import com.ist.servicemotorapi.spring.core.models.entities.ServiceMotorcycle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {
    public static ResponseEntity<Object> failedResponse(HttpStatus status) {

        String message;
        String finalStatus;
        if(status.value()==204){
            message = "Not Found";
            finalStatus = status.toString();
        } else if (status.value()==400){
            message = "Bad Request";
            finalStatus = status.toString();
        } else if (status.value()==404){
            message = "Data Not Found";
            finalStatus = status.toString();
        } else if (status.value()==500){
            message = "Unknown Error";
            finalStatus = "UNKNOWN_ERROR";
        } else {
            message = "Undefind Error";
            finalStatus = "UNDEFIND_ERROR";
        }

        Map<String, String> responeMap = new HashMap<String, String>();
        responeMap.put("message", message);
        responeMap.put("status", finalStatus);

        return new ResponseEntity<Object>(responeMap, status);
    }

    public static ResponseEntity<Object> successResponse(ServiceMotorcycle serviceMotorcycle, HttpStatus status){
        Map<String, String> responeMap = new HashMap<String, String>();
        responeMap.put("id", serviceMotorcycle.getId().toString());
        responeMap.put("merk", serviceMotorcycle.getMerk());
        responeMap.put("motorcycle_type", serviceMotorcycle.getMotorcycle_type());
        responeMap.put("owner", serviceMotorcycle.getOwner());
        responeMap.put("service_type", serviceMotorcycle.getService_type());
        responeMap.put("complaint", serviceMotorcycle.getComplaint());
        responeMap.put("cost", serviceMotorcycle.getCost().toString());
        responeMap.put("created_at", serviceMotorcycle.getCreated_at());
        responeMap.put("created_by", serviceMotorcycle.getCreated_by());
        responeMap.put("updated_at", serviceMotorcycle.getUpdated_at());
        responeMap.put("is_deleted", serviceMotorcycle.getIs_deleted().toString());

        return new ResponseEntity<Object>(responeMap, status);
    }
}
