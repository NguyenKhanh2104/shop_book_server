package com.example.api_shop_book.mapper;


import com.example.api_shop_book.model.Book;
import com.example.api_shop_book.payload.response.BookResponse;

public class BookMapper {

    public static BookResponse toBookResp(Book book) {
        BookResponse bookResp = new BookResponse();

        bookResp.setId(book.getId());
        bookResp.setName(book.getName());
        bookResp.setImg(book.getImg());
        bookResp.setDescription(book.getDescription());
        bookResp.setStatus(book.getStatus());
        bookResp.setPrice(book.getPrice());
        bookResp.setSalePrice(book.getSalePrice());
        bookResp.setCategory(book.getCategory().getName());
        bookResp.setAuthor(book.getAuthor());

        return bookResp;
    }
//    public static PostRequest toDto (Post post){
//        PostRequest postReq = new PostRequest();
//        postReq.setId(post.getId());
//        postReq.setUsername(post.getUser().getUsername());
//        postReq.setContent(post.getContent());
//        postReq.setImg(post.getBook().getImage());
//        postReq.setBookName(post.getBook().getName());
//        postReq.setStatus(post.getBook().getStatus());
//        postReq.setDescription(post.getBook().getDescription());
//        postReq.setCategory(post.getBook().getCategory().getName());
//        return postReq;
//    }
}
