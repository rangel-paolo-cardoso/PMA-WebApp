package com.rangel.projectmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rangel.projectmanagement.dao.EmployeeRepostory;
import com.rangel.projectmanagement.dao.ProjectRepository;
import com.rangel.projectmanagement.dto.ChartData;
import com.rangel.projectmanagement.dto.EmployeeProject;
import com.rangel.projectmanagement.entities.Project;

@Controller
public class HomeController {

    @Value("${version}")
    private String version;
    
    @Autowired
    ProjectRepository proRepo;

    @Autowired
    EmployeeRepostory empRepo;

    @GetMapping("/")
    public String displayHome(Model model) throws JsonProcessingException {

        model.addAttribute("versionNumber", version);

        // we are querying database for projects
        List<Project> projects = proRepo.findAll();
        model.addAttribute("projects", projects);

        List<ChartData> projectData = proRepo.getProjectStatus();

        // Lets convert a projectData object into a json structure for use in Javascript
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(projectData);
        model.addAttribute("projectStatusCount", jsonString);

        // we are querying database for employees
        List<EmployeeProject> employeesProjectCount = empRepo.employeeProjects();
        model.addAttribute("employeesListProjectCount", employeesProjectCount);
        
        return "main/home";
    }
}
