package com.example.api_shop_book.helper;

import com.example.api_shop_book.dto.BookDTO;
import com.example.api_shop_book.model.Book;
import com.example.api_shop_book.services.Impl.BookServiceImpl;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BookHelper {
    @Autowired
    private ModelMapper modelMapper;
    private final BookServiceImpl bookService;

    public ResponseEntity<BookDTO> getBookById(Integer id) throws Exception {
        Book book = bookService.getBookId(id);
        BookDTO bookResponse = modelMapper.map(book, BookDTO.class);

        return ResponseEntity.ok().body(bookResponse);
//        if (book != null) {
//            return ResponseEntity.ok(book);
//        }
//        return null;
    }

    public List<BookDTO> getAllBook() {


        return bookService.findAllBook().stream().map(book -> modelMapper.map(book, BookDTO.class))
                .collect(Collectors.toList());
    }
//    public ResponseEntity<?> getAllBook() {
//            List<Book> books = bookService.findAllBook();
//
//        List<BookResponse> resp = books.stream()
//                .map(post -> BookMapper.toBookResp(post))
//                .collect(Collectors.toList());
//
//        return ResponseEntity.ok(resp);
//    }

//    public ResponseEntity<List<Book>> getAllBook() {
//        List<Book> book = bookService.findAllBook();
//        if (book != null) {
//            System.out.println(true);
//            return ResponseEntity.ok(book);
//        }
//        return null;
//    }

    public ResponseEntity<BookDTO> getBookByName(String name) {
        Book book = bookService.getName(name);
        BookDTO bookResponse = modelMapper.map(book, BookDTO.class);
        return ResponseEntity.ok().body(bookResponse);
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
