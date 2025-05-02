package com.example.EmployeeSpringBoot.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_employee")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeEntity {

    @Id
    private String employeeId;
    private String firstName;
    private  String lastName;
    private String emailId;
    private String  department;
}
