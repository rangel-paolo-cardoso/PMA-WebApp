package com.rangel.projectmanagement.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rangel.projectmanagement.dao.EmployeeRepostory;
import com.rangel.projectmanagement.entities.Employee;

@RestController
@RequestMapping("/app-api/employees")
public class EmployeeApiController {
    
    @Autowired
    EmployeeRepostory empRepo;

    @GetMapping
    public Iterable<Employee> getEmployees() {
        return empRepo.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id) {
        return empRepo.findById(id).get();
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus( HttpStatus.CREATED)
    public Employee create(@RequestBody Employee employee) {
        return empRepo.save(employee);
    }
}
