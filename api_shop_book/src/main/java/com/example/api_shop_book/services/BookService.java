package com.example.api_shop_book.services;

import com.example.api_shop_book.model.Book;
import com.example.api_shop_book.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BookService {
    Book getBookId(Integer bookId) throws Exception;
    Book createBook(Book book);
    Book getName(String name);
    Book getBookById(Integer bookId) throws Exception;
    void delete(Integer bookId);
    List<Book> findAllBook();

    Book updateBook(Integer id, Book bookDetail) throws Exception;
}
