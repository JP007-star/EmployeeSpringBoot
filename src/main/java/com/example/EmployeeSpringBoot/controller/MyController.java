package com.example.EmployeeSpringBoot.controller;

import com.example.EmployeeSpringBoot.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class MyController   {
    static ArrayList<Employee> employeeArrayList;
    static {
        employeeArrayList=new ArrayList<>();
        Employee e1=new Employee(1001,"Jaya Prasad","Software Architect",  26745629.42);
        Employee e2=new Employee(1002,"Jaya Prasad","Software Architect",  26745629.42);
        Employee e3=new Employee(1003,"Jaya Prasad","Software Architect", 26745629.42);
        Employee e4=new Employee(1004,"Jaya Prasad","Software Architect",  26745629.42);
        employeeArrayList.add(e1);
        employeeArrayList.add(e2);
        employeeArrayList.add(e3);
        employeeArrayList.add(e4);
    }
    @GetMapping("/employees")
    public ArrayList<Employee> getEmployee(){
        return employeeArrayList;
    }
    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable Integer id){
        for(Employee e:employeeArrayList){
            if(id==e.getEmpId()) {
               return e;
            }
        }
        return null;
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@RequestBody Employee employee){
        employeeArrayList.add(employee);
        return "Employee Added successfully";
    }
    @DeleteMapping("/delete/{empId}")
    public String deleteEmployee(@PathVariable Integer empId){
        Employee temp=null;
        boolean found=false;
        for(Employee e:employeeArrayList){
            if(empId==e.getEmpId()) {
                temp = e;
                found = true;
                break;
            }
        }
        employeeArrayList.remove(temp);
        if(found)
            return "Employee  "+temp.getName()+" is deleted..";
        else{
            return "Employee not found";
        }
    }
    @PutMapping("/update/{empId}")
    public String updateEmployee(@RequestBody Employee employee,@PathVariable Integer empId){
       deleteEmployee(empId);
       employeeArrayList.add(employee);
       return "Updated Successfully!..";
    }

}
