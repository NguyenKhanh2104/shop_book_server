package com.example.api_shop_book.services;

import com.example.api_shop_book.model.User;

public interface UserService {
    public User findById(Integer userId) throws Exception;
}
