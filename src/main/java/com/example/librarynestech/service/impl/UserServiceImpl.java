package com.example.librarynestech.service.impl;

import com.example.librarynestech.Repository.userRepository;
import com.example.librarynestech.entity.User;
import com.example.librarynestech.service.UserService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService<User> {
     @Autowired private userRepository userRepository;


    @Override
    public User creat(User input) {
        return null;
    }

    @Override
    public List<User> getAllUser() {
        return(List<User>) userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        // TODO Auto-generated method stub
        userRepository.save(user);
        return user;
    }

    @Override
    public boolean deleteUser(String id) {
        // TODO Auto-generated method stub
        userRepository.deleteById(id);
        return true;
    }

    @Override
    public Optional<User> findUserById(String id) {
        // TODO Auto-generated method stub
        return userRepository.findById(id);
    }  

}
