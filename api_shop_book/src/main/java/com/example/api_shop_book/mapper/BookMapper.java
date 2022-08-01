package com.example.api_shop_book.mapper;


import com.example.api_shop_book.dto.BookDTO;
import com.example.api_shop_book.model.Book;
import com.example.api_shop_book.model.Category;
import com.example.api_shop_book.payload.response.BookResponse;
import com.example.api_shop_book.services.BookService;
import com.example.api_shop_book.services.CategoryService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookMapper {

   @Autowired
   CategoryService categoryService;
    public Book toBookResp(BookDTO bookDto) {
        Book book = new Book();
        book.setName(bookDto.getName());
        book.setImg(bookDto.getImg());
        book.setDescription(bookDto.getDescription());
        book.setStatus(bookDto.getStatus());
        book.setPrice(bookDto.getPrice());
        book.setSalePrice(bookDto.getSalePrice());
        book.setCategory(categoryService.getCategoryByName(bookDto.getCategory()));
        book.setAuthor(bookDto.getAuthor());

        return book;
    }
    public BookDTO toDto(Book book){
        BookDTO newBook = new BookDTO();
        newBook.setId(book.getId());
        newBook.setName(book.getName());
        newBook.setAuthor(book.getAuthor());
        newBook.setStatus(book.getStatus());
        newBook.setImg(book.getImg());
        newBook.setPrice(book.getPrice());
        newBook.setSalePrice(book.getSalePrice());
        newBook.setDescription(book.getDescription());
        String nameCategory = book.getCategory().getName();
        newBook.setCategory(nameCategory);
        return newBook;
    }
}
