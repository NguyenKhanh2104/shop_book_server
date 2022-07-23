package com.example.api_shop_book.helper;

import com.example.api_shop_book.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

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
