package com.example.librarynestech.repository;

import com.example.librarynestech.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
