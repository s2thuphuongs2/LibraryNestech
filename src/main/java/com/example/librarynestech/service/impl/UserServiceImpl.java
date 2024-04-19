package com.example.librarynestech.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.librarynestech.Repository.userRepository;
import com.example.librarynestech.entity.User;
import com.example.librarynestech.service.CloudinaryService;
import com.example.librarynestech.service.UserService;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import org.apache.commons.io.FilenameUtils;

@Service
public class UserServiceImpl implements UserService<User> {
     @Autowired private userRepository userRepository;
     @Autowired private CloudinaryService cloudinaryService;
    private final Cloudinary cloudinary;

    public UserServiceImpl(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }


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
    @Override
    public void uploadAvatar(String userId, MultipartFile file) throws IOException {
        // Tìm kiếm người dùng trong cơ sở dữ liệu
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Người dùng không tồn tại với ID: " + userId));

        // Tạo tên file và định dạng file
        String fileName = user.getId() + "-" + file.getOriginalFilename();
        String fileExtension = FilenameUtils.getExtension(file.getOriginalFilename());

        // Upload file ảnh lên Cloudinary
        Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());

        // Lưu trữ URL ảnh vào database
        String avatarUrl = (String) uploadResult.get("url");
        user.setImage(avatarUrl);
        userRepository.save(user);

    }
}
