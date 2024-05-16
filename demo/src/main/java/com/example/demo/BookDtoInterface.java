package com.example.demo;

public interface BookDtoInterface {

    Book getBookById(int bookId);
    int createBook(BookRequest bookRequest);
    void updateBook(int bookId, BookRequest bookRequest);
    void deleteBookById(int bookId);
}