package com.example.librarynestech.service;

import java.util.Optional;
import java.util.List;  
import org.springframework.stereotype.Service;

import com.example.librarynestech.entity.User;

@Service
public interface UserService {
    List<User> getAllUser();  

  void saveUser(User user);  

  void deleteUser(Long id);  

  Optional<User> findUserById(Long id); 
}
