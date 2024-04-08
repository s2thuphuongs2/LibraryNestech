package com.example.librarynestech.service;

import com.example.librarynestech.entity.Book;

public interface BookService {

    public Book getBookById(Long id);

    public Book addBook(Book newBook);
    public Book updateBook(Long bookId, Book updatedBook);

    public void deleteBook(Long bookId);

    public Iterable<Book> getAllBooks();
}
