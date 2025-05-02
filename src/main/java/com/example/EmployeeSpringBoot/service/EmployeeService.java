package com.example.EmployeeSpringBoot.service;

import com.example.EmployeeSpringBoot.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(Employee employee);

    List<Employee> getAllEmployee();

    Employee getEmployeeById(String id);

    String  deleteEmployeeById(String id);
}
