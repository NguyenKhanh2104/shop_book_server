//package com.example.api_shop_book.models;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.Date;
//
//@Entity
//@Table(name = "post")
//@Getter
//@Setter
//public class Post {
//    @Id
//    @Column(name = "id", nullable = false)
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Integer id;
//
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private User user;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "book_id")
//    private Book book;
//
//    @Column(name = "title")
//    private String title;
//
//    @Lob
//    @Column(name = "content")
//    private String content;
//
//    @Column(name = "date")
//    private Date date;
//
//
//}