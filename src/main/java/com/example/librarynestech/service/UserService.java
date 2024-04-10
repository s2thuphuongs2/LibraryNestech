package com.example.librarynestech.service;

import java.util.Optional;
import java.util.List;  
import org.springframework.stereotype.Service;

import com.example.librarynestech.entity.User;

@Service
public interface UserService<T> {
    T creat(T input);
    List<T> getAllUser();

  T saveUser(T newvalue);

   boolean deleteUser(Long id);

  Optional<T> findUserById(Long id);
}
