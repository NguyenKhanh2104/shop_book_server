package com.example.api_shop_book.services;

import com.example.api_shop_book.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BookService {
    Book getBookId(Integer bookId) throws Exception;

    Book getName(String name);

    Book getBookById(Integer bookId) throws Exception;

    List<Book> findAllBook();
}
