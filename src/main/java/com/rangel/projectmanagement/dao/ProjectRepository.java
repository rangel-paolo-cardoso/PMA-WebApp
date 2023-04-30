package com.rangel.projectmanagement.dao;

import org.springframework.data.repository.CrudRepository;

import com.rangel.projectmanagement.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {
    
}
