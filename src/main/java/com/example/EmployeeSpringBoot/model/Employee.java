package com.example.EmployeeSpringBoot.model;

public class Employee {
    int empId;
    String name;
    String designation;
    double salary;

    public Employee(int empId,String name, String designation, double salary) {
        this.empId=empId;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}
