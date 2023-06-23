package com.rangel.projectmanagement.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rangel.projectmanagement.dao.EmployeeRepostory;
import com.rangel.projectmanagement.dao.ProjectRepository;
import com.rangel.projectmanagement.entities.Employee;
import com.rangel.projectmanagement.entities.Project;
import com.rangel.projectmanagement.services.EmployeeService;
import com.rangel.projectmanagement.services.ProjectService;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectService proService;

    @Autowired
    EmployeeService empService;

    @GetMapping
    public String displayProjects(Model model) {
        List<Project> projects = proService.findAll();
        model.addAttribute("projects", projects);

        return "projects/list-projects";
    }
    
    @GetMapping("/new")
    public String displayProjectForm(Model model) {

        Project aProject = new Project();
        Iterable<Employee> employees = empService.findAll();
        model.addAttribute("project", aProject);
        model.addAttribute("allEmployees", employees);

        return "projects/new-project";
    }

    @PostMapping("/save")
    public String createProject(@Valid Project project, Errors errors) {

        if (errors.hasErrors()) {
            return "projects/new-project";
        }

        proService.save(project);
        // use a redirect to prevent duplicate submissions
        return "redirect:/projects";
    }

    @GetMapping("/update")
    public String displayProjectUpdateForm(@RequestParam("id") long id, Model model) {
        Project project = proService.findByProjectId(id);
        model.addAttribute("project", project);
        return "projects/new-project";
    }

    @GetMapping("/delete")
    public String deleteProject(@RequestParam("id") long id) {
        Project project = proService.findByProjectId(id);
        proService.delete(project);
        return "redirect:/projects";
    }
}
