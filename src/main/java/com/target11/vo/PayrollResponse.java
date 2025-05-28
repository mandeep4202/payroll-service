package com.target11.vo;

import com.target11.model.Employee;
import com.target11.model.PayrollRecord;

public class PayrollResponse {

  private Employee employee;
  private PayrollRecord payrollRecord;

  public PayrollResponse() {}

  public PayrollResponse(Employee employee, PayrollRecord payrollRecord) {
    this.employee = employee;
    this.payrollRecord = payrollRecord;
  }

  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

  public PayrollRecord getPayrollRecord() {
    return payrollRecord;
  }

  public void setPayrollRecord(PayrollRecord payrollRecord) {
    this.payrollRecord = payrollRecord;
  }
}
