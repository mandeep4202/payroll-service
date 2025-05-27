package com.target11.model;

import lombok.Data;

@Data
public class Employee {
    private String id;
    private String name;
    private String designation;
    private double baseSalary;
    private double taxRate;
}