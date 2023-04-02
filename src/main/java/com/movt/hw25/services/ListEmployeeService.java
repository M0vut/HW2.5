package com.movt.hw25.services;

import com.movt.hw25.domain.exceptions.EmployeeAlreadyAddedException;
import com.movt.hw25.domain.exceptions.EmployeeNotFoundException;
import com.movt.hw25.domain.exceptions.EmployeeStorageIsFullException;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


import com.movt.hw25.domain.Employee;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class ListEmployeeService implements EmployeeService {
    private static final int CAPACITY = 10;
    List<Employee> staff = new ArrayList<>();

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee temp = new Employee(firstName, lastName);
        if (staff.size() >= CAPACITY) {
            throw new EmployeeStorageIsFullException();
        }
        if (staff.contains(temp)) {
            throw new EmployeeAlreadyAddedException();
        }
        staff.add(temp);
        return temp;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        int index = staff.indexOf(new Employee(firstName, lastName));
        if (index == -1) {
            throw new EmployeeNotFoundException();
        }


        return staff.remove(index);
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        int index = staff.indexOf(new Employee(firstName, lastName));
        if (index == -1) {
            throw new EmployeeNotFoundException();
        }
        return staff.get(index);
    }
}
