package com.example.api_shop_book.services.Impl;
import com.example.api_shop_book.model.User;
import com.example.api_shop_book.repository.UserRepository;
import com.example.api_shop_book.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepo;
    @Override
    public User findById(Integer userId) throws Exception {
        return this.userRepo.findById(userId).orElseThrow(() ->new Exception("User is not found"));
    }
}
