package com.example.librarynestech.service;

import java.io.IOException;
import java.util.Optional;
import java.util.List;  
import org.springframework.stereotype.Service;

import com.example.librarynestech.entity.User;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface UserService<T> {
    T creat(T input);
    List<T> getAllUser();

  T saveUser(T newvalue);

   boolean deleteUser(String id);

  Optional<T> findUserById(String id);

  void uploadAvatar(String id, MultipartFile file) throws IOException;
}
