package com.example.api_shop_book.services;

import com.example.api_shop_book.model.User;
import com.example.api_shop_book.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepo;

    public User findById(Integer userId) throws Exception {
        // TODO Auto-generated method stub
        return this.userRepo.findById(userId).orElseThrow(() ->new Exception("User is not found"));
    }
}
