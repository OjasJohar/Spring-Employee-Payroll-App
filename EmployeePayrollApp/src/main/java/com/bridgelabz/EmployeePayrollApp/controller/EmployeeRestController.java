package com.bridgelabz.EmployeePayrollApp.controller;

/*
   Use Case : 7
   Use Lombok Library for Logging
   Note: using Annotation @Slf4j at Class Level, Logging is activated
   Note: Logging Levels, Files and Patterns are handled in application.properties
   Database is not used.
*/

import com.bridgelabz.EmployeePayrollApp.dto.EmployeePayrollDTO;
import com.bridgelabz.EmployeePayrollApp.model.Employee;
import com.bridgelabz.EmployeePayrollApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employeePayrollService")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("")
    public List<Employee> getAllEmployeeDetails() {
        return employeeService.getAllEmployeeDetails();
    }

    @GetMapping("/get/{id}")
    public Optional<Employee> getSpecificEmployeeDetails(@PathVariable long id) {
        Employee employee = employeeService.getEmployeeDetailsByID(id);
        if (employee != null) {
            return Optional.of(employee);
        } else {
            return Optional.empty();
        }
    }

    @PostMapping("/create")
    public String creatingEmployeeRecord(@RequestBody EmployeePayrollDTO employeeDTO){
        Employee employee=employeeService.createEmployeeRecord(employeeDTO);
        return "Created employee record\nname = " + employee.getName() + "\nsalary = " + employee.getSalary();
    }

    @PutMapping("/update/{id}")
    public String updatingEmployeeDetails(@PathVariable long id,@RequestBody EmployeePayrollDTO employeeDTO) {
        Employee employee = employeeService.updateEmployeeRecord(id, employeeDTO);
        if (employee != null) {
            return "Updated employee record\nname = " + employee.getName() + "\nsalary = " + employee.getSalary();
        } else {
            return "Employee record not found";
        }
    }

    @DeleteMapping("/delete/{id}")
    public String deletingEmployeeDetails(@PathVariable long id){
        return employeeService.deleteEmployeeRecordByID(id);
    }

}