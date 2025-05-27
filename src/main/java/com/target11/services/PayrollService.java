package com.target11.services;

import com.target11.config.EmployeeClient;
import com.target11.model.Employee;
import com.target11.model.PayrollRecord;
import com.target11.repositories.PayrollRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PayrollService {

    private final EmployeeClient employeeClient;
    private final PayrollRepository payrollRepository;

    PayrollService(EmployeeClient employeeClient, PayrollRepository payrollRepository) {
        this.employeeClient = employeeClient;
        this.payrollRepository = payrollRepository;
    }

    public PayrollRecord generatePayroll(String employeeId) {
        // Call Employee Service
        Employee emp = employeeClient.getEmployeeById("EWS1234");

        // Calculate salary
        double taxAmount = emp.getBaseSalary() * emp.getTaxRate();
        double netSalary = emp.getBaseSalary() - taxAmount;

        PayrollRecord record = new PayrollRecord();
        record.setEmployeeId(emp.getId());
        record.setGrossSalary(emp.getBaseSalary());
        record.setTaxRate(emp.getTaxRate());
        record.setTaxAmount(taxAmount);
        record.setNetSalary(netSalary);
        record.setDateGenerated(LocalDate.now());

        return payrollRepository.save(record);
    }

    public List<PayrollRecord> getPayrollHistory(String employeeId) {
        return payrollRepository.findByEmployeeId(employeeId);
    }

}