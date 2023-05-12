package com.rangel.projectmanagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rangel.projectmanagement.dto.EmployeeProject;
import com.rangel.projectmanagement.entities.Employee;

public interface EmployeeRepostory extends CrudRepository<Employee, Long> {

    @Override
    public List<Employee> findAll();

    @Query(
        nativeQuery = true,
        value = ""
            + "SELECT"
            + "  e.first_name as firstName,"
            + "  e.last_name as lastName,"
            + "  COUNT(pe.employee_id) as projectCount "
            + "FROM employee e "
            + "LEFT JOIN project_employee pe "
            + "ON pe.employee_id = e.employee_id "
            + "GROUP BY e.first_name, e.last_name "
            + "ORDER BY 3 DESC"
    )
    public List<EmployeeProject> employeeProjects();
}
