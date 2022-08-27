package com.microservice.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.user.entities.User;

public interface UserRepository extends JpaRepository<User,Integer>{

}
