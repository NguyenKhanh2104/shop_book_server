package com.example.api_shop_book.dto;

import lombok.Data;

@Data
public class AddToCartDTO {
    long id;
    String nameBook;
    Integer bookId;
    int qty;
    double price;
    Integer user_id;
    String added_date;
}
