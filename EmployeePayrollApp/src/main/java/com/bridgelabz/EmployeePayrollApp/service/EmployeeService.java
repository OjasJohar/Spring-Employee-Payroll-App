package com.bridgelabz.EmployeePayrollApp.service;

import com.bridgelabz.EmployeePayrollApp.dto.EmployeePayrollDTO;
import com.bridgelabz.EmployeePayrollApp.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.bridgelabz.EmployeePayrollApp.exception.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class EmployeeService {

    List<Employee> employees;
    private static int empId=1;

    EmployeeService(){
        employees=new ArrayList<>();
    }

    public List<Employee> getAllEmployeeDetails(){
        return employees;
    }

    public Employee getEmployeeDetailsByID(long id) {
        return employees.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    public Employee createEmployeeRecord(EmployeePayrollDTO employeeDTO){
        Employee employee=new Employee(empId,employeeDTO);
        empId++;
        employees.add(employee);
        return employee;
    }

    public Employee updateEmployeeRecord(long id,EmployeePayrollDTO employeeDTO) {
        Employee employee = getEmployeeDetailsByID(id);

        String name = employeeDTO.getName();
        double salary = employeeDTO.getSalary();

        if (!name.isEmpty()) {
            employee.setName(name);
        }
        if (salary > 0) {
            employee.setSalary(salary);
        }
        return employee;
    }

    public String deleteEmployeeRecordByID(long id) {
        Employee employee = getEmployeeDetailsByID(id);

        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i) == employee) {
                employees.remove(i);
                return "Deleted Employee record with id " + id;
            }
        }

        return "Employee record not found";
    }

}