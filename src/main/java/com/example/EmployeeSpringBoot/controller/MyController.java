package com.example.EmployeeSpringBoot.controller;

import com.example.EmployeeSpringBoot.model.Employee;
import com.example.EmployeeSpringBoot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class MyController   {

    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public Employee addEmployee(@RequestBody  Employee employee){
        return employeeService.addEmployee(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/{id}")
    public Employee getAllEmployee(@PathVariable String id){
        return employeeService.getEmployeeById(id);
    }


}
