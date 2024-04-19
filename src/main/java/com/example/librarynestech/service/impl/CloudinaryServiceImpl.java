package com.example.librarynestech.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.librarynestech.service.CloudinaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CloudinaryServiceImpl implements CloudinaryService {
    // Lỗi could not autowire. No beans of 'Cloudinary' type found.
    // add scanBasePackages = {"com.cloudinary"} to @SpringBootApplication
    private final Cloudinary cloudinary;

    public String uploadFile(MultipartFile path) {
        try {
            Map uploadResult = cloudinary.uploader().upload(path, ObjectUtils.emptyMap());
            return uploadResult.get("url").toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
