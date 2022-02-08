package com.example.BackEnd.backRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BackEnd.BackModel.Role;

public interface BackRoleRepository extends JpaRepository<Role, Integer>{
}
