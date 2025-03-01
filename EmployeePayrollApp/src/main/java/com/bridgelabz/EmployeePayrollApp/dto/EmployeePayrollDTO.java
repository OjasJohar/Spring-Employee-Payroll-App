package com.bridgelabz.EmployeePayrollApp.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString //this generates the toString method automatically.
public class EmployeePayrollDTO {

    @NotBlank(message = "Name is required and cannot be empty.")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "Name must contain only letters and spaces (3-50 characters).")
    private String name;

    @Min(value = 500, message = "Min wage should be more than 500")
    private double salary;

    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;
    private List<String> departments;
}
