package com.example.api_shop_book.dto;

import com.example.api_shop_book.model.Category;
import lombok.Data;

@Data
public class BookDTO {
        Integer id;
        String name;
        String img;
        String description;
        Boolean status;
        Double price;
        Double salePrice;
        String category;
        String author;
}
