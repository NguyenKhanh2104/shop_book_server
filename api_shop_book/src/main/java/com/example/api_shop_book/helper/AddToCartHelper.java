package com.example.api_shop_book.helper;

import com.example.api_shop_book.dto.AddToCartDTO;
import com.example.api_shop_book.mapper.BookMapper;
import com.example.api_shop_book.model.Book;
import com.example.api_shop_book.payload.response.BookResponse;
import com.example.api_shop_book.services.BookService;
import com.example.api_shop_book.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AddToCartHelper {

    private final CartService cartService;




//    public ResponseEntity<?> updateBook(Book book) {
//        Book newBook = bookService.updateBook(book);
//        if (newBook != null) {
//            return ResponseEntity.ok(newBook);
//        }
//        return ResponseEntity.badRequest().body("Could not update: "+book);
//    }
}
