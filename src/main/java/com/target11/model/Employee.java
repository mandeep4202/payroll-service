package com.target11.model;

import lombok.Data;

@Data
public class Employee {
    private String id;
    private String firstName;
    private String lastName;
    private String designation;
    private String email;
    private double baseSalary;
    private double taxRate;
}