package com.example.api_shop_book.payload.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Data
public class UserResponse {
    Integer id;
    String email;
    String password;
    String phone;
    String username;

//
    String fullname;
    String img;
    String address;
    Date birthday;
    String sex;
    String position;

}
