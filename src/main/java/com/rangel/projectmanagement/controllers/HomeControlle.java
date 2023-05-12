package com.rangel.projectmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.rangel.projectmanagement.dao.EmployeeRepostory;
import com.rangel.projectmanagement.dao.ProjectRepository;
import com.rangel.projectmanagement.dto.EmployeeProject;
import com.rangel.projectmanagement.entities.Employee;
import com.rangel.projectmanagement.entities.Project;

@Controller
public class HomeControlle {
    
    @Autowired
    ProjectRepository proRepo;

    @Autowired
    EmployeeRepostory empRepo;

    @GetMapping("/")
    public String displayHome(Model model) {
        // we are querying database for projects
        List<Project> projects = proRepo.findAll();
        model.addAttribute("projects", projects);

        // we are querying database for employees
        List<EmployeeProject> employeesProjectCount = empRepo.employeeProjects();
        model.addAttribute("employeesListProjectCount", employeesProjectCount);
        
        return "main/home";
    }
}
