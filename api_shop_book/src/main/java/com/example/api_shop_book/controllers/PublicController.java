package com.example.api_shop_book.controllers;

import com.example.api_shop_book.helper.BookHelper;
import com.example.api_shop_book.model.Book;
import com.example.api_shop_book.services.Impl.BookServiceImpl;
import com.example.api_shop_book.services.Impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/public/")
public class PublicController {
    private final BookHelper bookHelper;

    @Autowired
    private BookServiceImpl bookService;

    @Autowired
    private UserServiceImpl userService;
    @GetMapping("/allBook")
    public ResponseEntity<?> getAllBook() {
        return bookHelper.getAllBook();
    }



    @GetMapping("/find/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Integer id) throws Exception {
        return bookHelper.getBookById(id);
    }



}
