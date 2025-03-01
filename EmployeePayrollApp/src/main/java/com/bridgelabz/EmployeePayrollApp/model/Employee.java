package com.bridgelabz.EmployeePayrollApp.model;

import com.bridgelabz.EmployeePayrollApp.dto.EmployeePayrollDTO;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Employee {

    //private static long idCounter=1;
    private int id;
    private String name;
    private double salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;
    private List<String> departments;

    public Employee() {
//        id=idCounter;
//        idCounter++;
    }

    public Employee(int empId, EmployeePayrollDTO employeePayrollDTO){
        this.id=empId;
        this.name=employeePayrollDTO.getName();
        this.salary=employeePayrollDTO.getSalary();
        this.gender=employeePayrollDTO.getGender();
        this.note=employeePayrollDTO.getNote();
        this.startDate=employeePayrollDTO.getStartDate();
        this.profilePic=employeePayrollDTO.getProfilePic();
        this.departments=employeePayrollDTO.getDepartments();
    }
}