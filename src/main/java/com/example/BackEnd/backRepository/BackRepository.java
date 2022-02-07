package com.example.BackEnd.backRepository;

import com.example.BackEnd.BackModel.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BackRepository extends JpaRepository<User, Integer>{
    
}
