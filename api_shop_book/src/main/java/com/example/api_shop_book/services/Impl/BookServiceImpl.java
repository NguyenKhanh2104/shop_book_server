package com.example.api_shop_book.services.Impl;

import com.example.api_shop_book.model.Book;
import com.example.api_shop_book.repository.BookRepository;
import com.example.api_shop_book.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepo;

    @Override
    public Book getBookId(Integer bookId) throws Exception {
        return bookRepo.findById(bookId).orElseThrow(() ->new Exception("Book is not found"));
    }
//    public List<Book> getBookResponse(){
//        List<Book> posts = bookRepo.findAll();
//        bookRepo.
//        return posts;
//    }
@Override
public Book getName(String name) {
    Optional<Book> u = Optional.ofNullable(bookRepo.finBookByname(name));
        return u.get();
    }
//    public Book addBook(Book book) {
//        return bookRepo.save(book);
//    }
@Override
public Book getBookById(Integer bookId) throws Exception {
    return bookRepo.findById(bookId).orElseThrow(() ->new Exception("Book is not found"));
}

    public List<Book> findAllBook() {
        return bookRepo.findAll();
    }
//    public Book findById(Integer id){
//        return bookRepo.findBookById(id).orElseThrow(()-> new BookNotFoundException("Book by id" + id+"was not found"));
//    }

//    public Book updateBook(Book book) {
//        return bookRepo.save(book);
//    }
//
//    public void deleteBook(Integer id) {
//        bookRepo.deleteBookById(id);
//    }


}
