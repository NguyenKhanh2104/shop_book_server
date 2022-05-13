//package com.example.api_shop_book.models;
//
//import javax.persistence.*;
//import java.time.Instant;
//
//@Entity
//@Table(name = "fileupload")
//public class Fileupload {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id", nullable = false)
//    private Integer id;
//
//
//    @Column(name = "name", nullable = false)
//    private String name;
//
//    @Column(name = "content", nullable = false)
//    private String content;
//
//    @Column(name = "size", nullable = false)
//    private Integer size;
//
//    @Column(name = "upload_time", nullable = false)
//    private Instant uploadTime;
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public Integer getSize() {
//        return size;
//    }
//
//    public void setSize(Integer size) {
//        this.size = size;
//    }
//
//    public Instant getUploadTime() {
//        return uploadTime;
//    }
//
//    public void setUploadTime(Instant uploadTime) {
//        this.uploadTime = uploadTime;
//    }
//
//}