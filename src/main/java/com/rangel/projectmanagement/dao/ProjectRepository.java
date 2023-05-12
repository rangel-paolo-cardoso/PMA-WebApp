package com.rangel.projectmanagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rangel.projectmanagement.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {
    
    @Override
    public List<Project> findAll();

    @Query(
        nativeQuery = true,
        value = ""
            + "SELECT"
            + "  stage as label,"
            + "  COUNT(*) as value "
            + "FROM project "
            + "GROUP BY stage "
    )
    public List<> complteProjects();
}
