package com.example.librarynestech.config;

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration //Cho Spring biet class này chua cac phuong thuc cau hinh Bean can thiet cho ung dung
public class CloudinaryConfig {
    @Value("${cloudinary.cloud-name}") // xem ben application.properties
    private String cloudName;

    @Value("${cloudinary.api-key}")
    private String apiKey;

    @Value("${cloudinary.api-secret}")
    private String apiSecret;

    /**
     * @return Cloudinary
     */
    @Bean
    public Cloudinary cloudinary() { // Không cần định nghĩa Map cấu hình
        return new Cloudinary(); // Cloudinary SDK sẽ lấy cấu hình từ application.properties
    }

    //Bỏ đoạn code tạo Map config. Bean Cloudinary trả về trong getCloudinary()
    // đã được Cloudinary Java SDK tự xử lý cấu hình thông qua các giá trị được
    // lấy từ application.properties.

//    @Bean
//    public Cloudinary getCloudinary() {
//        Map config = new HashMap();
//        config.put("cloud_name", cloudName); // your cloudinary cloud name in console.cloudinary.com
//        config.put("api_key", apiKey);
//        config.put("api_secret", apiSecret);
//        config.put("secure", true);
//        return new Cloudinary(config);
//    }
}
