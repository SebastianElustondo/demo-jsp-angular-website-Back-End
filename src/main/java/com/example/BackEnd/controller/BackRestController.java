package com.example.BackEnd.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.BackEnd.BackModel.User;
import com.example.BackEnd.BackService.BackService;

@RestController
public class BackRestController {

    @Autowired
    private BackService service;

    @GetMapping("/getUsersList")
    @CrossOrigin(origins = "*")
    public List<User> getUserList(){
        List<User> users = new ArrayList<User>();
        // Call service to bring data from the database
        users = service.getUsersList();
        return users;
    }

    @GetMapping("/getUserByID/{id}")
    @CrossOrigin(origins = "*")
    public User getUserByID(@PathVariable Integer id){
        User user = new User();
        // Call service to bring data from the database
        user = service.getUserByID(id);
        return user;
    }

    @PostMapping("/saveUser")
    @CrossOrigin(origins = "*")
    public User saveUser(@RequestBody User user){   
        // Call service to send data to the database
        return service.saveUser(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    @CrossOrigin(origins = "*")
    public String deleteUser(@PathVariable Integer id){
        return service.deleteUser(id);
    }
}
