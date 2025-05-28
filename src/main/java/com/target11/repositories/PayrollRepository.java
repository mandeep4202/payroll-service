package com.target11.repositories;

import com.target11.model.PayrollRecord;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PayrollRepository extends MongoRepository<PayrollRecord, String> {
    List<PayrollRecord> findByEmployeeId(String employeeId);

}