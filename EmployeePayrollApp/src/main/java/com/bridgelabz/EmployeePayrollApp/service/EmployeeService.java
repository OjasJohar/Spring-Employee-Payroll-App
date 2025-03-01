package com.bridgelabz.EmployeePayrollApp.service;

import com.bridgelabz.EmployeePayrollApp.dto.EmployeePayrollDTO;
import com.bridgelabz.EmployeePayrollApp.exception.EmployeeNotFoundException;
import com.bridgelabz.EmployeePayrollApp.model.Employee;
import com.bridgelabz.EmployeePayrollApp.repository.EmployeePayrollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmployeeService {

    @Autowired
    private EmployeePayrollRepository employeeRepository;

    public List<Employee> getAllEmployeeDetails(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeDetailsByID(long id) {
        return employeeRepository
                .findById(id)
                .orElseThrow( ()->new EmployeeNotFoundException(id));
    }

    public List<Employee> getEmployeeByDepartment(String department) {
        return employeeRepository.findEmployeesByDepartment(department);
    }

    public Employee createEmployeeRecord(EmployeePayrollDTO employeeDTO){
        Employee employee=new Employee(employeeDTO);
        employeeRepository.save(employee);
        return employee;
    }

    public Employee updateEmployeeRecord(long id,EmployeePayrollDTO employeeDTO) {
        Employee employee = getEmployeeDetailsByID(id);
        employee.updateEmployeeData(employeeDTO);
        return employeeRepository.save(employee);
    }

    public String deleteEmployeeRecordByID(long id) {
        Employee employee = getEmployeeDetailsByID(id);
        if(employee!=null){
            employeeRepository.delete(employee);
            return "Employee data with id " + id + " is deleted";
        }
        return "Employee record not found";
    }

}