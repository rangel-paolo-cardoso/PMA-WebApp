package com.rangel.projectmanagement.dao;

import org.springframework.data.repository.CrudRepository;

import com.rangel.projectmanagement.entities.Employee;

public interface EmployeeRepostory extends CrudRepository<Employee, Long> {
    
}
