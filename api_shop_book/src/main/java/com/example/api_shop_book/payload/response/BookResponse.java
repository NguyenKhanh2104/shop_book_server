package com.example.api_shop_book.payload.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Data
public class BookResponse {
    Integer id;
    String name;
    String img;
    String description;
    Boolean status;
    Double price;
    Double salePrice;
    String category;
    String author;
    Date date;




}
