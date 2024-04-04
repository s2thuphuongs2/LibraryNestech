package com.example.librarynestech.service.impl;

import com.example.librarynestech.Repository.userRepository;
import com.example.librarynestech.entity.User;
import com.example.librarynestech.service.UserService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
     @Autowired private userRepository userRepository;

    @Override
    public List<User> getAllUser() {
        return(List<User>) userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        // TODO Auto-generated method stub
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        // TODO Auto-generated method stub
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> findUserById(Long id) {
        // TODO Auto-generated method stub
        return userRepository.findById(id);
    }  

}
