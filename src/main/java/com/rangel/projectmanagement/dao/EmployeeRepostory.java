package com.rangel.projectmanagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.rangel.projectmanagement.dto.EmployeeProject;
import com.rangel.projectmanagement.entities.Employee;

@RepositoryRestResource(collectionResourceRel = "apiemployees", path = "apiemployees")
public interface EmployeeRepostory extends PagingAndSortingRepository<Employee, Long> {

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

    public Employee findByEmail(String email);
}
