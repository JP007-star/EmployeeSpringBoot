package com.example.EmployeeSpringBoot.service;

import com.example.EmployeeSpringBoot.entity.EmployeeEntity;
import com.example.EmployeeSpringBoot.model.Employee;
import com.example.EmployeeSpringBoot.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeV2ServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;


    @Override
    public Employee addEmployee(Employee employee) {
        if (employee.getEmployeeId() == null || employee.getEmployeeId().isEmpty()) {
            employee.setEmployeeId(UUID.randomUUID().toString());
        }
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepository.save(employeeEntity);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployee() {

        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        List<Employee> employeeList = employeeEntities
                .stream()
                .map(employeeEntity -> {
                    Employee employee = new Employee();
                    BeanUtils.copyProperties(employeeEntity, employee);
                    return employee;
                }).toList();
        return employeeList;
    }

    @Override
    public Employee getEmployeeById(String id) {
        EmployeeEntity employeeEntity=employeeRepository.findById(id).get();
        Employee employee=new Employee();
        BeanUtils.copyProperties(employeeEntity,employee);
        return employee;
    }

    @Override
    public String deleteEmployeeById(String id) {
        employeeRepository.deleteById(id);
        return "Employee with Id %d is got deleted"+id;
    }
}
