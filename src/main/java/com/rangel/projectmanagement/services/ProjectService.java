package com.rangel.projectmanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rangel.projectmanagement.dao.ProjectRepository;
import com.rangel.projectmanagement.entities.Project;

@Service
public class ProjectService {
    
    @Autowired
    ProjectRepository proRepo;

    public List<Project> findAll() {
        return proRepo.findAll();
    }

    public void save(Project project) {
        proRepo.save(project);
    }

    public Project findByProjectId(long id) {
        return proRepo.findById(id).get();
    }

    public void delete(Project project) {
        proRepo.delete(project);
    }


}
