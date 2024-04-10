package com.example.librarynestech.service.impl;

import com.example.librarynestech.entity.Book;
import com.example.librarynestech.exception.BookNotFoundException;
import com.example.librarynestech.Repository.BookRepository;
import com.example.librarynestech.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    @Override
    public Book addBook(Book newBook) {
        return bookRepository.save(newBook);
    }

    @Override
    public Book updateBook(Long bookId, Book updatedBook) {
        // Check if the book exists
        Book existingBook = bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException(bookId));
        // Update the book
        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setPages(updatedBook.getPages());
        existingBook.setGenre(updatedBook.getGenre());
        existingBook.setAddDate(updatedBook.getAddDate());
        existingBook.setImage(updatedBook.getImage());
        existingBook.setDescription(updatedBook.getDescription());
        // Save the updated book
        return bookRepository.save(existingBook);
    }

    @Override
    public void deleteBook(Long bookId) {
        // Check if the book exists
        bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException(bookId));
        // Delete the book
        bookRepository.deleteById(bookId);
    }
    // TODO: thay thành List
    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

}
