package com.example.api_shop_book.mapper;

import com.example.api_shop_book.model.User;
import com.example.api_shop_book.payload.response.UserResponse;

public class UserMapper {
    public static UserResponse toUserResp(User user){
        UserResponse userResp = new UserResponse();
        userResp.setId(user.getId());
        userResp.setEmail(user.getEmail());
        userResp.setPassword(user.getPassword());
        userResp.setPhone(user.getPhone());
        userResp.setUsername(user.getUsername());

//
        userResp.setFullname(user.getFullname());
        userResp.setImg(user.getImg());
        userResp.setAddress(user.getAddress());
        userResp.setBirthday(user.getBirthday());
        userResp.setSex(user.getSex());
        userResp.setPosition(user.getPosition());

        return userResp;
    }
}
