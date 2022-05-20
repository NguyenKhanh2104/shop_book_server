package com.example.api_shop_book.exception;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String mess){
        super(mess);
    }
}
