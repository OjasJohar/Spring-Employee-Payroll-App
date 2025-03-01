package com.bridgelabz.EmployeePayrollApp.repository;

import com.bridgelabz.EmployeePayrollApp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeePayrollRepository extends JpaRepository<Employee, Long> {
}
