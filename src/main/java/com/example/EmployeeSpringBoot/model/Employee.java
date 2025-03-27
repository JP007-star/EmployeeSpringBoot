package com.example.EmployeeSpringBoot.model;


import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
    private String employeeId;
    private String firstName;
    private  String lastName;
    private String emailId;
    private String  department;
}
