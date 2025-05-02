package com.example.EmployeeSpringBoot.service;

import com.example.EmployeeSpringBoot.exception.EmployeeNotFoundException;
import com.example.EmployeeSpringBoot.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    List<Employee> employeeList=new ArrayList<>();

    @Override
    public Employee addEmployee(Employee employee) {
        if(employee.getEmployeeId()==null || employee.getEmployeeId().isEmpty()){
            employee.setEmployeeId(UUID.randomUUID().toString());
        }
        employeeList.add(employee);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeList;
    }

    @Override
    public Employee getEmployeeById(String id) {
        return employeeList.stream().filter(e->e.getEmployeeId().equalsIgnoreCase(id))
                .findFirst().orElseThrow(()->new RuntimeException("Employee not found"));
    }

    @Override
    public String deleteEmployeeById(String id) {
        Optional<Employee> employee=employeeList.stream().filter(e->e.getEmployeeId().equals(id)).findFirst();
        employeeList.remove(employee);
        return "deleted successfully ..!";
    }
}
