package com.example.librarynestech.controller;


import com.example.librarynestech.entity.User;
import com.example.librarynestech.service.UserService;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private UserService<User> userService;

    @GetMapping
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @PostMapping
    public User create(@RequestBody User input){
        return userService.creat(input);
    }

    @PutMapping
    public User saveUser(@RequestBody User newvalue){
        return userService.saveUser(newvalue);
    }
    @DeleteMapping("/{id}")
    public boolean deleteUser(String id){
        return userService.deleteUser(id);
    }

    @PostMapping("/upload-avatar")
    public ResponseEntity<Void> uploadAvatar(@RequestParam String userId, @RequestParam MultipartFile file) throws IOException {
        userService.uploadAvatar(userId, file);
        return ResponseEntity.ok().build();
    }
}
