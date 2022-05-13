//package com.example.api_shop_book.models;
//
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "book")
//@Getter
//@Setter
//public class Book{
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "Id", nullable = false)
//    private Integer id;
//
//    @Lob
//    @Column(name = "Name")
//    private String name;
//
//    @JoinColumn(name = "url_image")
//    @Column(name = "url_image")
//    private String image;
//
//    @Lob
//    @Column(name = "description")
//    private String description;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "category_id")
//    private Category category;
//
//    @Column(name = "status")
//    private Boolean status;
//
//    @Column(name = "author")
//    private String author;
//
//
//
//
//}