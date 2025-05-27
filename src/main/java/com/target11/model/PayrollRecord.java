package com.target11.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "payrolls")
public class PayrollRecord {
    @Id
    private String id;

    private String employeeId;
    private double grossSalary;
    private double taxRate;
    private double taxAmount;
    private double netSalary;
    private LocalDate dateGenerated;
}