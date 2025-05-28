package com.target11.services;

import com.target11.config.EmployeeClient;
import com.target11.model.Employee;
import com.target11.model.PayrollRecord;
import com.target11.model.SalaryConfig;
import com.target11.repositories.PayrollRepository;
import com.target11.repositories.SalaryConfigRepository;
import com.target11.vo.PayrollResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PayrollService {

  private final EmployeeClient employeeClient;
  private final PayrollRepository payrollRepository;
  private final SalaryConfigRepository salaryConfigRepository;

  PayrollService(
      EmployeeClient employeeClient,
      PayrollRepository payrollRepository,
      SalaryConfigRepository salaryConfigRepository) {
    this.employeeClient = employeeClient;
    this.payrollRepository = payrollRepository;
    this.salaryConfigRepository = salaryConfigRepository;
  }

  public PayrollResponse generatePayroll(String employeeId) {
    // Call Employee Service
    Employee emp = employeeClient.getEmployeeById(employeeId);
    SalaryConfig salaryConfig = salaryConfigRepository.findByEmployeeId(employeeId);

    if (salaryConfig == null) {
      // add default salary configuration if not found
      salaryConfig = new SalaryConfig();
      salaryConfig.setEmployeeId(employeeId);
      salaryConfig.setBasicSalary(10000);
      salaryConfig.setTaxRate(.2);
    }

    // Calculate salary
    double taxAmount = salaryConfig.getBasicSalary() * salaryConfig.getTaxRate();
    double netSalary = salaryConfig.getBasicSalary() - taxAmount;

    PayrollRecord record = new PayrollRecord();
    record.setEmployeeId(emp.getId());
    record.setGrossSalary(emp.getBaseSalary());
    record.setTaxRate(emp.getTaxRate());
    record.setTaxAmount(taxAmount);
    record.setNetSalary(netSalary);
    record.setDateGenerated(LocalDate.now());

    payrollRepository.save(record);
    return new PayrollResponse(emp, record);
  }

  public List<PayrollRecord> getPayrollHistory(String employeeId) {
    return payrollRepository.findByEmployeeId(employeeId);
  }
}
