package com.bridgelabz.EmployeePayrollApp.model;

import com.bridgelabz.EmployeePayrollApp.dto.EmployeePayrollDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity //tells Hibernate to create a table out of the Employee Payroll Class.
@Table(name = "employee_payroll") //specifies the mapped Table in DB.
public class Employee {

    @Id //specifies the Primary Key.
    @GeneratedValue(strategy = GenerationType.AUTO) //id generation is set to auto.
    private int id;

    @Column(name = "name")
    private String name;

    private double salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;

    @ElementCollection
    @CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "department")
    private List<String> departments;

    public Employee() { }

    public Employee(EmployeePayrollDTO employeePayrollDTO){
        this.updateEmployeeData(employeePayrollDTO);
    }

    public void updateEmployeeData(EmployeePayrollDTO employeePayrollDTO){
        this.name=employeePayrollDTO.getName();
        this.salary=employeePayrollDTO.getSalary();
        this.gender=employeePayrollDTO.getGender();
        this.note=employeePayrollDTO.getNote();
        this.startDate=employeePayrollDTO.getStartDate();
        this.profilePic=employeePayrollDTO.getProfilePic();
        this.departments=employeePayrollDTO.getDepartments();
    }
}