package com.example.api_shop_book.services;

import com.example.api_shop_book.model.Book;
import com.example.api_shop_book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepo;


//    public Book getById(Integer id) {
//        return bookRepo.findById(id).orElse(null);
//    }
//    public Book addBook(Book book) {
//        return bookRepo.save(book);
//    }

    public List<Book> findAllBook() {
        return bookRepo.findAll();
    }

//    public Book updateBook(Book book) {
//        return bookRepo.save(book);
//    }
//
//    public void deleteBook(Integer id) {
//        bookRepo.deleteBookById(id);
//    }

}
