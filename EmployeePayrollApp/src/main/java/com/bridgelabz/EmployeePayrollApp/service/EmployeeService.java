package com.bridgelabz.EmployeePayrollApp.service;

import com.bridgelabz.EmployeePayrollApp.dto.EmployeePayrollDTO;
import com.bridgelabz.EmployeePayrollApp.model.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    public String getAllEmployeeDetails(){
        return "GET: getting all employee record";
    }

    public String getEmployeeDetailsByID(long id){
        return "GET: getting employee record with id " + id ;
    }

    public Employee createEmployeeRecord(EmployeePayrollDTO employeeDTO){
        Employee employee=new Employee();

        String name=employeeDTO.getName();
        double salary=employeeDTO.getSalary();

        employee.setName(name);
        employee.setSalary(salary);

        return employee;
    }

    public Employee updateEmployeeRecord(EmployeePayrollDTO employeeDTO){
        Employee employee=new Employee();

        String name=employeeDTO.getName();
        double salary=employeeDTO.getSalary();

        employee.setName(name);
        employee.setSalary(salary);

        return employee;
    }

    public String deleteEmployeeRecordByID(long id){
        return "DELETE: deleted employee record with id " + id ;
    }

}