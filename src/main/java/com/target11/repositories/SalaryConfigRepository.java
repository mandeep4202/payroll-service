package com.target11.repositories;

import com.target11.model.SalaryConfig;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SalaryConfigRepository extends MongoRepository<SalaryConfig, String> {
   SalaryConfig findByEmployeeId(String employeeId);

}