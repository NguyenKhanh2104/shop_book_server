package com.example.api_shop_book.services;

import com.example.api_shop_book.model.Book;
import com.example.api_shop_book.model.User;
import com.example.api_shop_book.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    User findById(Integer userId) throws Exception;
    List<User> findAllUser();
    User createUser(User user);
    void deleteUser(Integer userId);
    User updateUser(Integer userId, User userDetail) throws Exception;
}
