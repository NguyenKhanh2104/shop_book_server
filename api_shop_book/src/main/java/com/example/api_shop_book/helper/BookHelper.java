package com.example.api_shop_book.helper;

import com.example.api_shop_book.dto.BookDTO;
import com.example.api_shop_book.mapper.BookMapper;
import com.example.api_shop_book.model.Book;
import com.example.api_shop_book.model.Category;
import com.example.api_shop_book.model.User;
import com.example.api_shop_book.payload.response.BookResponse;

import com.example.api_shop_book.services.BookService;
import com.example.api_shop_book.services.CategoryService;
import com.example.api_shop_book.services.Impl.BookServiceImpl;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

    @Component
    @RequiredArgsConstructor
public class BookHelper {
    @Autowired
    private ModelMapper modelMapper;
    private final BookService bookService;
    @Autowired
    BookMapper bookMapper;

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
        List<Book> list = bookService.findAllBook();
        List<BookDTO> rs = new ArrayList<>();
        for (Book b: list
             ) {
            BookDTO bookDto  = bookMapper.toDto(b);
            rs.add(bookDto);
        }

        return rs;
    }

    public ResponseEntity<?> updateBook(Integer id, Book bookDetail) throws Exception {
        Book book = bookService.updateBook(id, bookDetail);

        if (book != null) {
            return ResponseEntity.ok(book);
        }
        return ResponseEntity.badRequest().body("Could not add : " + book);


    }

    public ResponseEntity<BookDTO> createBook(BookDTO bookRequest) {
//        Book book = new Book();
//        book.setName(bookRequest.getName());
//        book.setImg(bookRequest.getImg());
//        book.setDescription(bookRequest.getDescription());
//        book.setCategory(categoryService.getCategoryByName(bookRequest.getCategory()));
//        book.setPrice(bookRequest.getPrice());
//        book.setSalePrice(bookRequest.getSalePrice());
//        book.setAuthor(bookRequest.getAuthor());
//        book.setStatus(bookRequest.getStatus());
//        bookService.createBook(book);
//        return ResponseEntity.ok(bookRequest);
        Book book = bookMapper.toBookResp(bookRequest);
        bookService.createBook(book);
        BookDTO bookDto = bookMapper.toDto(book);
        return ResponseEntity.ok(bookDto);
    }

    public void deteleBook(Integer Id) {
        bookService.delete(Id);
    }

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
