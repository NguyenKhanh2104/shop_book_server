package com.example.api_shop_book.payload.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class CartResponse {
    long id;
    String nameBook;
    Integer bookId;
    int qty;
    double price;
    Integer user_id;
    String added_date;
}
