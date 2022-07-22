package com.example.api_shop_book.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@Table(name = "cart")
public class AddtoCart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    long id;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    Book book;

    int qty;
    double price;
    Integer user_id;
    @Column(updatable = false, insertable = false)
    String added_date;
    @Transient
    String img;
    @Transient
    String bookName;
    public String getBookName() {
        return book.getName();
    }

    public String getImg() {
        return book.getImg();
    }

    public int updateQty(int add) {
        return qty+=add;
    }
}
