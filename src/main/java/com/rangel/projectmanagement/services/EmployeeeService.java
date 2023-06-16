package com.rangel.projectmanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rangel.projectmanagement.dao.EmployeeRepostory;
import com.rangel.projectmanagement.dto.EmployeeProject;
import com.rangel.projectmanagement.entities.Employee;


@Service
public class EmployeeeService {
    
    @Autowired
    EmployeeRepostory empRepo;

    public Employee save(Employee employee) {
        return empRepo.save(employee);
    }

    public Iterable<Employee> getAll() {
        return empRepo.findAll();
    }

    public List<EmployeeProject> employeeProject() {
        return empRepo.employeeProjects();
    }
}
