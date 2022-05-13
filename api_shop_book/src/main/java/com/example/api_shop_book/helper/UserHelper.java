//package com.example.api_shop_book.helper;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//
//@Component
//@RequiredArgsConstructor
//public class UserHelper {
////    private final UserService userService;
//
////    public ResponseEntity<List<User>> getAllUser() {
////        List<User> user = userService.findAllBook();
////        if (user != null) {
////            System.out.println(true);
////            return ResponseEntity.ok(user);
////        }
////        return null;
////    }
////    public User registerUser(@RequestBody User user) throws Exception {
////        String tempEmail = user.getEmail();
////        if(tempEmail!=null && !"".equals(tempEmail)){
////                User userObj  = userService.getUserByEmail(tempEmail);
////                if(userObj!=null){
////                    throw  new Exception("user with"+tempEmail+"is already exits");
////                }
////        }
////        User userObj = null;
////        userObj = userService.saveUser(user);
////        return userObj;
////    }
////    public User login(@RequestBody User user) throws Exception {
////        String tempUsername = user.getUsername();
////        String tempPassword = user.getPassword();
////        User userObj = null;
////        if(tempUsername!=null && tempPassword!=null){
////           userObj = userService.getUserByUsernameAndPassword(tempUsername,tempPassword);
////        }
////        if(userObj==null) {
////            throw new Exception("Bad credentials");
////        }
////        return userObj;
////    }
//}
