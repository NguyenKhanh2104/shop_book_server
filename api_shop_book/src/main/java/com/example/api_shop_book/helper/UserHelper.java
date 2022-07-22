package com.example.api_shop_book.helper;

import com.example.api_shop_book.mapper.BookMapper;
import com.example.api_shop_book.mapper.UserMapper;
import com.example.api_shop_book.model.Book;
import com.example.api_shop_book.model.User;
import com.example.api_shop_book.payload.response.BookResponse;
import com.example.api_shop_book.payload.response.UserResponse;
import com.example.api_shop_book.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserHelper {
    private final UserService userService;

    public ResponseEntity<?> getAllUser() {
//        List<User> user = userService.findAllUser();
//        if (user != null) {
//            System.out.println(true);
//            return ResponseEntity.ok(user);
//        }
//        return null;
        List<User> user = userService.findAllUser();

        List<UserResponse> resp = user.stream()
                .map(post -> UserMapper.toUserResp(post))
                .collect(Collectors.toList());

        return ResponseEntity.ok(resp);
    }

    public ResponseEntity<?> createUser(User user) {
         User newUser = userService.createUser(user);
        if (newUser != null) {
            return ResponseEntity.ok(newUser);
        }
        return ResponseEntity.badRequest().body("Could not add : "+user);
    }

    public ResponseEntity<?> findId(Integer userId) throws Exception {
        User userID = userService.findById(userId);
        if (userID != null) {
            return ResponseEntity.ok(userID);
        }
        return ResponseEntity.badRequest().body("Could not add : "+userID);
    }

    public void deteleUser(Integer userId) {
         userService.deleteUser(userId);
//        if (userID != null) {
//            return ResponseEntity.ok(userID);
//        }
//        return ResponseEntity.badRequest().body("Could not add : "+userID);
    }

    public ResponseEntity<?> updateUser(Integer userId, User userDetail) throws Exception {
        User userNew = userService.updateUser(userId, userDetail);
        System.out.println("bị lỗi đây à");
        if (userNew != null) {
            return ResponseEntity.ok(userNew);
        }
        return ResponseEntity.badRequest().body("Could not add : "+userNew);


    }
//    public User save(User user) {
//        return
//    }
//    public User registerUser(@RequestBody User user) throws Exception {
//        String tempEmail = user.getEmail();
//        if(tempEmail!=null && !"".equals(tempEmail)){
//                User userObj  = userService.getUserByEmail(tempEmail);
//                if(userObj!=null){
//                    throw  new Exception("user with"+tempEmail+"is already exits");
//                }
//        }
//        User userObj = null;
//        userObj = userService.saveUser(user);
//        return userObj;
//    }
//    public User login(@RequestBody User user) throws Exception {
//        String tempUsername = user.getUsername();
//        String tempPassword = user.getPassword();
//        User userObj = null;
//        if(tempUsername!=null && tempPassword!=null){
//           userObj = userService.getUserByUsernameAndPassword(tempUsername,tempPassword);
//        }
//        if(userObj==null) {
//            throw new Exception("Bad credentials");
//        }
//        return userObj;
//    }
}
