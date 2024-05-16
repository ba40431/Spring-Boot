package com.example.demo;

public interface BookServiceInterface {
    Book getBookById(int bookId);
    int createBook(BookRequest bookRequest);
    void updateBook(Integer bookId, BookRequest bookRequest);
    void deleteBookById(int bookId);
} 
