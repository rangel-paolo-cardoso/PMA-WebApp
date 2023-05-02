package com.rangel.projectmanagement.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rangel.projectmanagement.entities.Employee;

public interface EmployeeRepostory extends CrudRepository<Employee, Long> {
    
    @Override
    public List<Employee> findAll();
}
