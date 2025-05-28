package com.target11.config;

import com.target11.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "employee-service", url = "http://localhost:30080")
public interface EmployeeClient {
    @GetMapping("/api/employees/{id}")
    Employee getEmployeeById(@PathVariable("id") String id);
}