package com.example.api_shop_book.helper;

import com.example.api_shop_book.model.Book;
import com.example.api_shop_book.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BookHelper {

    private final BookService bookService;

    public ResponseEntity<Book> getBookById(Integer id) {
        Book book = bookService.getById(id);
        if (book != null) {
            return ResponseEntity.ok(book);
        }
        return null;
    }

    public ResponseEntity<List<Book>> getAllBook() {
        List<Book> book = bookService.findAllBook();
        if (book != null) {
            System.out.println(true);
            return ResponseEntity.ok(book);
        }
        return null;
    }

    public ResponseEntity<Book> getBookByName(String name) {
        Book book = bookService.getName(name);
        if (book != null) {
            return ResponseEntity.ok(book);
        }
        return null;
    }

//    public ResponseEntity<?> addBook(Book book) {
//         Book newBook = bookService.addBook(book);
//        if (newBook != null) {
//            return ResponseEntity.ok(newBook);
//        }
//        return ResponseEntity.badRequest().body("Could not add : "+book);
//    }
//    public ResponseEntity<?> updateBook(Book book) {
//        Book newBook = bookService.updateBook(book);
//        if (newBook != null) {
//            return ResponseEntity.ok(newBook);
//        }
//        return ResponseEntity.badRequest().body("Could not update: "+book);
//    }
}
