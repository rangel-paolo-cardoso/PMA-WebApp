package com.rangel.projectmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rangel.projectmanagement.dao.EmployeeRepostory;
import com.rangel.projectmanagement.dao.ProjectRepository;

@SpringBootApplication
public class ProjectManagementApplication {

	@Autowired
	EmployeeRepostory empRepo;

	@Autowired
	ProjectRepository projRepo;

	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementApplication.class, args);
	}
}
