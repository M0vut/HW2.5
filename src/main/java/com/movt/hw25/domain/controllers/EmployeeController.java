package com.movt.hw25.domain.controllers;

import com.movt.hw25.domain.Employee;
import com.movt.hw25.services.ArrayEmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")

public class EmployeeController {
    private final ArrayEmployeeService service;

    public EmployeeController(ArrayEmployeeService service) {
        this.service = service;
    }


    @GetMapping
    public String hello(){
        return "HELLOЁПТ ДРУЖИЩЕ";
    }
    @GetMapping("/add")
    public Employee add(@RequestParam String firstName,@RequestParam String lastName){
        return service.addEmployee(firstName,lastName);
    }
    @GetMapping("/remove")
    public Employee remove(@RequestParam String firstName,@RequestParam String lastName){
        return service.removeEmployee(firstName,lastName);
    }
    @GetMapping("/find")
    public Employee find(@RequestParam String firstName,@RequestParam String lastName){
        return service.findEmployee(firstName,lastName);
    }
}
