package com.example.api_shop_book.services.Impl;
import com.example.api_shop_book.model.User;
import com.example.api_shop_book.repository.UserRepository;
import com.example.api_shop_book.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepo;
    public User findById(Integer userId) throws Exception {
        // TODO Auto-generated method stub
        return this.userRepo.findById(userId).orElseThrow(() ->new Exception("User is not found"));
    }

    public List<User> findAllUser(){

        System.out.println("username của ai: " +userRepo.findAll());
        return userRepo.findAll();
    }

    public User createUser(User user){
        return userRepo.save(user);
    }

    public void deleteUser(Integer userId) {
        userRepo.deleteById(userId);
    }

    public User updateUser(Integer userId, User userDetail) throws Exception {
        User user = userRepo.findById(userId).orElseThrow(() -> new Exception("User is not found"));
        user.setEmail(userDetail.getEmail());
//        user.setPassword(user.getPassword());
        user.setPhone(userDetail.getPhone());
        user.setUsername(userDetail.getUsername());

//
        user.setFullname(userDetail.getFullname());
//        user.setImg(user.getImg());
        user.setAddress(userDetail.getAddress());
//        user.setBirthday(user.getBirthday());
        user.setSex(userDetail.getSex());
        user.setPosition(userDetail.getPosition());

        userRepo.save(user);
        System.out.println("có chạy vô đây không " + userRepo.toString());
        System.out.println("có chạy vô đây không " + userRepo.getById(6));
        return userRepo.save(user);
    }
}
