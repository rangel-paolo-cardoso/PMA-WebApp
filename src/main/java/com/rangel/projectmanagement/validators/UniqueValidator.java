package com.rangel.projectmanagement.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.rangel.projectmanagement.dao.EmployeeRepostory;
import com.rangel.projectmanagement.entities.Employee;

public class UniqueValidator implements ConstraintValidator<UniqueValue, String> {

    @Autowired
    EmployeeRepostory empRepo;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        System.out.println("Entered validation method..");

        
        Employee emp = empRepo.findByEmail(value);

        if (emp != null) {
            return false;
        }
        return true;
    }

}
