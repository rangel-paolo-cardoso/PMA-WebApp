package com.rangel.projectmanagement.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rangel.projectmanagement.entities.Employee;
import com.rangel.projectmanagement.services.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService empService;

    @GetMapping
    public String displayEmployees(Model model) {
        Iterable<Employee> employees = empService.findAll();
        model.addAttribute("employees", employees);
        return "employees/list-employees";
    }
    
    @GetMapping("/new")
    public String displayEmployeeForm(Model model) {
        Employee anEmployee = new Employee();
        model.addAttribute("employee", anEmployee);
        return "employees/new-employee";
    }

    @PostMapping("/save")
    public String createEmployeee(Model model, @Valid Employee employee, Errors errors) {

        if (errors.hasErrors()) {
            return "employees/new-employee";
        }

        // save to the database using an employee crud repository
        empService.save(employee);
        return "redirect:/employees";
    }

    @GetMapping("/update")
    public String displayEmployeeUpdateForm(@RequestParam("id") long id, Model model) {
        Employee employee = empService.findByEmployeeId(id);
        model.addAttribute("employee", employee);
        return "employees/new-employee";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("id") long id) {
        Employee employee = empService.findByEmployeeId(id);
        empService.delete(employee);
        return "redirect:/employees";
    }
}
