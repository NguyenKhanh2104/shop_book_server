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
        return bookRepo.findById(bookId).orElseThrow(() -> new Exception("Book is not found"));
    }

    @Override
    public Book createBook(Book book) {
        return bookRepo.save(book);
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
        return bookRepo.findById(bookId).orElseThrow(() -> new Exception("Book is not found"));
    }

    @Override
    public void delete(Integer bookId) {
        bookRepo.deleteById(bookId);
    }

    public List<Book> findAllBook() {
        return bookRepo.findAll();
    }

    @Override
    public Book updateBook(Integer id, Book bookDetail) throws Exception {
        Book book = bookRepo.findById(id).orElseThrow(() -> new Exception("Book is not found"));
        book.setName(bookDetail.getName());
        book.setStatus(bookDetail.getStatus());
        book.setImg(bookDetail.getImg());
        book.setAuthor(bookDetail.getAuthor());
        book.setSalePrice(bookDetail.getSalePrice());
        book.setCategory(bookDetail.getCategory());
        book.setDescription(bookDetail.getDescription());
        book.setPrice(bookDetail.getPrice());
        bookRepo.save(book);

        return bookRepo.save(book);
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
