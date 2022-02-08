package com.example.BackEnd.BackService;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

import com.example.BackEnd.BackModel.User;
import com.example.BackEnd.backRepository.BackRepository;
import com.example.BackEnd.backRepository.BackRoleRepository;

@Service
public class BackUserService {
    
    @Autowired
    private BackRepository repository;
    @Autowired
    private BackRoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<User> getUsersList(){
        return repository.findAll();         
    }
    
    public User getUserByID(Integer id){
        User user = new User();
        try {
            user = repository.findById(id).get();
            
        } catch (Exception e) {
            // Do some string response and switch the type of return in case the user has nothing
        }
        return user;
    }

    public User saveUser(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet < > (roleRepository.findAll()));
        return repository.save(user);         
    }
    
    public String deleteUser(Integer id){
        String response = "";
        try {
            repository.deleteById(id);
            response="Succesfully deleted";
            
        } catch (Exception e) {
            response = "Could not delete the user";
        }
        return response;
    }
}
