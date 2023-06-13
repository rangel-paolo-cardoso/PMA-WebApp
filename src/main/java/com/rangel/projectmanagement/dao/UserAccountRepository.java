package com.rangel.projectmanagement.dao;

import org.springframework.data.repository.CrudRepository;

import com.rangel.projectmanagement.entities.UserAccount;

public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {
    
}
