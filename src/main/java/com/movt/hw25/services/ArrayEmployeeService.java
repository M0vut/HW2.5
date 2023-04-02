package com.movt.hw25.services;

import com.movt.hw25.domain.Employee;
import com.movt.hw25.domain.exceptions.EmployeeAlreadyAddedException;
import com.movt.hw25.domain.exceptions.EmployeeNotFoundException;
import com.movt.hw25.domain.exceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.Objects;
@Service
public class ArrayEmployeeService implements EmployeeService{
    private static final int CAPACITY = 10;
    private int currentSize = 0;

    private Employee[] staff = new Employee[CAPACITY];
    @Override
    public Employee addEmployee(String firstName, String lastName) {
        if (currentSize >= CAPACITY){
            throw new EmployeeStorageIsFullException(); //полный массив
        }
        Employee temp = new Employee(firstName,lastName);
        for (Employee emp:staff){
            if (Objects.equals(emp,temp)){
                throw new EmployeeAlreadyAddedException();  //есть сотрудник
            }
            staff[currentSize] = temp;
            currentSize++;
        }
        return temp;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee temp = new Employee(firstName,lastName);
        int i;
        for ( i = 0; i < currentSize; i++) {
          if (staff[i].equals(temp)) {
              break;
          }
          if (i == currentSize){
              throw new EmployeeNotFoundException();
          }
          for (int j = i; j < currentSize - 1; j++) {
              staff[j] = staff[j + 1];
          }
              currentSize--;
        }
        return null;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee temp = new Employee(firstName,lastName);
        for (var emp : staff){
            if (Objects.equals(emp,temp)) return emp;
        }
        throw new EmployeeNotFoundException();
    }
}
