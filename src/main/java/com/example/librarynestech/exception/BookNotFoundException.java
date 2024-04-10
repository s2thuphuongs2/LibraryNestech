package com.example.librarynestech.exception;
//TODO: Custom lai Exception
public class BookNotFoundException extends RuntimeException {
    private Long bookId;

    public BookNotFoundException(Long bookId) {
        super("Không tìm thấy sách có ID: " + bookId);
        this.bookId = bookId;
    }

    public Long getBookId() {
        return bookId;
    }
}
