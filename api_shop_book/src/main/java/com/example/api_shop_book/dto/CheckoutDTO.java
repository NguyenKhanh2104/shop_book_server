package com.example.api_shop_book.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CheckoutDTO {
    long idOrder;
    boolean status;
    String note, payment_type, delivery_address;
    Integer user_id;
    double totalPrice;
    Date dateCreate;

}
