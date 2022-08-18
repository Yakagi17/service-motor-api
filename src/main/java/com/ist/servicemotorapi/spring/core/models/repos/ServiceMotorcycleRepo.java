package com.ist.servicemotorapi.spring.core.models.repos;

import java.util.List;

import com.ist.servicemotorapi.spring.core.models.entities.ServiceMotorcycle;

import org.springframework.data.repository.CrudRepository;

public interface ServiceMotorcycleRepo extends CrudRepository<ServiceMotorcycle, Integer>{

    List<ServiceMotorcycle> findByStatus(String status);
}
