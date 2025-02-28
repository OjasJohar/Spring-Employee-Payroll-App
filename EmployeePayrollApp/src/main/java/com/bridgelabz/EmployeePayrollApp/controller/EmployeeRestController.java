package com.bridgelabz.EmployeePayrollApp.controller;

/*
   Use Case : 12
   Ability to throw User Friendly Errors in case Employee Id is not found in Employee Payroll App.
   - Define a Custom Exception for Employee Not Found and through when Employee Id is passed as parameter.
   - Handle such Exceptions in @ExceptionHandler method for EmployeeNotException class.
*/

import com.bridgelabz.EmployeePayrollApp.dto.EmployeePayrollDTO;
import com.bridgelabz.EmployeePayrollApp.model.Employee;
import com.bridgelabz.EmployeePayrollApp.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Employee getSpecificEmployeeDetails(@PathVariable long id) {
        return employeeService.getEmployeeDetailsByID(id);
    }

    @PostMapping("/create")
    public String creatingEmployeeRecord(@Valid @RequestBody EmployeePayrollDTO employeeDTO){
        Employee employee=employeeService.createEmployeeRecord(employeeDTO);
        return "Created employee record\nname = " + employee.getName() + "\nsalary = " + employee.getSalary();
    }

    @PutMapping("/update/{id}")
    public Employee updatingEmployeeDetails(@PathVariable long id, @Valid @RequestBody EmployeePayrollDTO employeeDTO) {
        return employeeService.updateEmployeeRecord(id, employeeDTO);
    }

    @DeleteMapping("/delete/{id}")
    public String deletingEmployeeDetails(@PathVariable long id){
        return employeeService.deleteEmployeeRecordByID(id);
    }

}