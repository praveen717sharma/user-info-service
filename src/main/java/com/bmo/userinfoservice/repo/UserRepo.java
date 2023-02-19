package com.bmo.userinfoservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bmo.bmomodel.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

}
