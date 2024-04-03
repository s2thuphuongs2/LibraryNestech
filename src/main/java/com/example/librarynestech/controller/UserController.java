package com.example.librarynestech.controller;

import com.example.librarynestech.entity.User;
import com.example.librarynestech.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class UserController {

    /**
     * {@code POST  /user} : Create a new user.
     * @param userService the user to create.
     * @return the {@link RequestEntity} with status {@code 201 (Created)} and with body the new user, or with status {@code 400 (Bad Request)} if the user has already an ID.
     */

}
