package com.example.librarynestech.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter
@Table(name = "user_id")
public class User {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String username;
    private String password;
    private String name;
    private String birthday;
    private String cardIdNumber;
    private String phoneNumber;
    private String address;
    private String image;

    @ManyToMany(mappedBy = "readers") // mappedBy is important here
    private Set<Book> books = new HashSet<>();

}
