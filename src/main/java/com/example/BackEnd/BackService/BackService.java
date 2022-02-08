package com.example.BackEnd.BackService;

import java.util.List;

import com.example.BackEnd.BackModel.User;

public interface BackService {
    void save(User user);

    User findByUsername(String username);

    List<User> getUsersList();
    
    User getUserByID(Integer id);

    User saveUser(User user);
    
    String deleteUser(Integer id);
}