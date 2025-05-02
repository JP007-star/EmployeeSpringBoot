package com.example.EmployeeSpringBoot.controller;

import com.example.EmployeeSpringBoot.model.Employee;
import com.example.EmployeeSpringBoot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v2/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

}
