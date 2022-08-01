package com.example.api_shop_book.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "checkout_item")
public class Checkout_Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    @ManyToOne()
    @JoinColumn(name = "checkout_id",nullable = false,referencedColumnName = "checkout_id")
    Checkout checkout;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    Book book;
    int qty;
    double price;
}
