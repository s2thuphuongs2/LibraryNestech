package com.example.librarynestech.service;

import com.example.librarynestech.entity.Book;
import com.example.librarynestech.repository.BookRepository;
import com.example.librarynestech.service.impl.BookServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class BookServiceTest {
    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetBookById() {
        Long bookId = 1L;
        Book mockBook = new Book();
        mockBook.setId(bookId);
        when(bookRepository.findById(bookId)).thenReturn(Optional.of(mockBook));

        Book foundBook = bookService.getBookById(bookId);

        assertNotNull(foundBook);
        assertEquals(bookId, foundBook.getId());
    }

    @Test
    public void testAddBook(){
        Book newBook = new Book();
        newBook.setTitle("Test Book");
        newBook.setAuthor("Test Author");
        newBook.setPages(100);
        newBook.setGenre("Test Genre");
        // Định dạng của chuỗi ngày
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Chuyển đổi chuỗi ngày thành LocalDate
        LocalDate localDate = LocalDate.parse("2024-01-01", formatter);

        // Chuyển đổi LocalDate thành Date (nếu cần thiết)
        Date date = java.sql.Date.valueOf(localDate);
        newBook.setAddDate(date);
        newBook.setImage("test.jpg");
        newBook.setDescription("Test Description");
        when(bookRepository.save(newBook)).thenReturn(newBook);

        Book addedBook = bookService.addBook(newBook);

        assertNotNull(addedBook);
        assertEquals(newBook.getTitle(), addedBook.getTitle());
        assertEquals(newBook.getAuthor(), addedBook.getAuthor());
        assertEquals(newBook.getPages(), addedBook.getPages());
        assertEquals(newBook.getGenre(), addedBook.getGenre());
        assertEquals(newBook.getAddDate(), addedBook.getAddDate());
        assertEquals(newBook.getImage(), addedBook.getImage());
        assertEquals(newBook.getDescription(), addedBook.getDescription());
    }

    @Test
    public void testUpdateBook() {
        Long bookId = 1L;
        Book existingBook = new Book();
        existingBook.setId(bookId);
        existingBook.setTitle("2 số phận");
        existingBook.setAuthor("Jeffrey Archer");
        existingBook.setPages(100);
        existingBook.setGenre("Tiểu thuyết");
        // Định dạng của chuỗi ngày
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Chuyển đổi chuỗi ngày thành LocalDate
        LocalDate localDate = LocalDate.parse("2024-01-01", formatter);

        // Chuyển đổi LocalDate thành Date (nếu cần thiết)
        Date date = java.sql.Date.valueOf(localDate);
        existingBook.setAddDate(date);
        existingBook.setImage("test.jpg");
        existingBook.setDescription("Truyện kể về 2 số phận khác nhau của 2 người bạn thân từ nhỏ. Một người trở thành chính trị gia, còn người kia trở thành tù nhân. Sự thay đổi của số phận đã khiến cho họ phải đối mặt với những khó khăn, thử thách trong cuộc sống.");

        Book updatedBook = new Book();
        updatedBook.setTitle("Updated Book");
        updatedBook.setAuthor("Updated Author");
        updatedBook.setPages(200);
        updatedBook.setGenre("Updated Genre");
        // Định dạng của chuỗi ngày
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Chuyển đổi chuỗi ngày thành LocalDate
        LocalDate localDate1 = LocalDate.parse("2024-01-01", formatter1);

        // Chuyển đổi LocalDate thành Date (nếu cần thiết)
        Date date1 = java.sql.Date.valueOf(localDate1);
        updatedBook.setAddDate(date1);
        updatedBook.setImage("updated.jpg");
        updatedBook.setDescription("Updated Description");

        when(bookRepository.findById(bookId)).thenReturn(Optional.of(existingBook));
        when(bookRepository.save(existingBook)).thenReturn(existingBook);

        Book updated = bookService.updateBook(bookId, updatedBook);

        assertNotNull(updated);
        assertEquals(existingBook.getId(), updated.getId());
        assertEquals(updatedBook.getTitle(), updated.getTitle());
        assertEquals(updatedBook.getAuthor(), updated.getAuthor());
        assertEquals(updatedBook.getPages(), updated.getPages());
        assertEquals(updatedBook.getGenre(), updated.getGenre());
        assertEquals(updatedBook.getAddDate(), updated.getAddDate());
        assertEquals(updatedBook.getImage(), updated.getImage());
        assertEquals(updatedBook.getDescription(), updated.getDescription());
    }

    @Test
    public void testDeleteBook() {
        Long bookId = 1L;
        Book existingBook = new Book();
        existingBook.setId(bookId);
        when(bookRepository.findById(bookId)).thenReturn(Optional.of(existingBook));

        bookService.deleteBook(bookId);
    }

@Test
    public void testGetAllBooks() {
        when(bookRepository.findAll()).thenReturn(null);

        Iterable<Book> books = bookService.getAllBooks();

        assertEquals(null, books);
    }
}
