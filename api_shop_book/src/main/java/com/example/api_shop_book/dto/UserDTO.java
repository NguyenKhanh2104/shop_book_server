package com.example.api_shop_book.dto;

import lombok.Data;

@Data
public class UserDTO {
    Integer id;
    String username;
    String password;
    String email;
    String phone;
}
