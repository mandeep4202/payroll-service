package com.target11.controller;

import com.target11.model.PayrollRecord;
import com.target11.services.PayrollService;
import com.target11.vo.PayrollResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payroll")
public class PayrollController {

  private final PayrollService payrollService;

  PayrollController(PayrollService payrollService) {
    this.payrollService = payrollService;

  }

  @PostMapping("/{employeeId}")
  public ResponseEntity<PayrollResponse> generate(@PathVariable String employeeId) {
    return ResponseEntity.ok(payrollService.generatePayroll(employeeId));
  }

  @GetMapping("/{employeeId}")
  public ResponseEntity<List<PayrollRecord>> history(@PathVariable String employeeId) {
    return ResponseEntity.ok(payrollService.getPayrollHistory(employeeId));
  }
}
