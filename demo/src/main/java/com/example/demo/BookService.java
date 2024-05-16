package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class BookService implements BookServiceInterface {
    
    @Autowired
    private BookDto bookDto;
    
    @Override
    public Book getBookById(int bookId){
        return bookDto.getBookById(bookId);
    }

    public int createBook(BookRequest bookRequest){
        return bookDto.createBook(bookRequest);
    }

    public void updateBook(Integer bookId, BookRequest bookRequest){
        bookDto.updateBook(bookId, bookRequest);
    }

    public void deleteBookById(int bookId) {
        bookDto.deleteBookById(bookId);
    }
}
