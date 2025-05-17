package com.example.EmployeeSpringBoot.controller;

import com.example.EmployeeSpringBoot.model.Employee;
import com.example.EmployeeSpringBoot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/employees")
public class EmployeeV1Controller {

    @Autowired
    @Qualifier("employeeServiceImpl")
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
    public Employee getByEmployeeId(@PathVariable String id){
        return employeeService.getEmployeeById(id);
    }


    @DeleteMapping("/{id}")
    public String deleteByEmployeeId(@PathVariable String id){
        return employeeService.deleteEmployeeById(id);
    }



}
