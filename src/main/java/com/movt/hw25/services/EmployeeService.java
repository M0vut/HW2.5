package com.movt.hw25.services;

import com.movt.hw25.domain.Employee;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName);
    Employee removeEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);
}
