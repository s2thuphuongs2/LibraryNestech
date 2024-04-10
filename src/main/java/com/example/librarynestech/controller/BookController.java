package com.example.librarynestech.controller;

import com.example.librarynestech.entity.Book;
import com.example.librarynestech.exception.BookNotFoundException;
import com.example.librarynestech.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
//TODO: Xoa Try Catch
    @GetMapping("/{bookId}")
    public ResponseEntity<Book> getBookById(@PathVariable Long bookId) {
            Book book = bookService.getBookById(bookId);
            return ResponseEntity.ok(book);
    }

    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody Book newBook) {

            Book addedBook = bookService.addBook(newBook);
            URI location = URI.create("/api/books/" + addedBook.getId());
            return ResponseEntity.created(location).body(addedBook);
    }

    @PutMapping("/update/{bookId}")
    public ResponseEntity<Book> updateBook(@PathVariable Long bookId, @RequestBody Book updatedBook) {
            Book updated = bookService.updateBook(bookId, updatedBook);
            return ResponseEntity.ok(updated);

    }

    @DeleteMapping("/delete/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long bookId) {
            bookService.deleteBook(bookId);
            return ResponseEntity.noContent().build();
    }
}
