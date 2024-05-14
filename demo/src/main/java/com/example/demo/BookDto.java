package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class BookDto implements BookDtoInterface {
    
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Book getBookById(int bookId){

        String sql = "SELECT book_id, title, author, image_url, price, published_date, created_date, last_modified_date " +
            "FROM book WHERE book_id = :bookId";

        Map<String, Object> map = new HashMap<>();
        map.put("bookId", bookId);

        List<Book> bookList = namedParameterJdbcTemplate.query(sql, map, new BookRowMapper());

        System.out.println(bookList);
        System.out.println(bookId);

        if(bookList.size() > 0){
            return bookList.get(0);
        }else {
            return null;
        }
    }
}
