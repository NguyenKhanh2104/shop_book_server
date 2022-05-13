//package com.example.api_shop_book.controllers;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.nio.file.StandardCopyOption;
//import java.util.List;
//
//@CrossOrigin(origins = "*", maxAge = 3600)
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/api/public")
//public class PublicController {
//    private final BookHelper bookHelper;
//    private final PostHelper postHelper;
//
//    @GetMapping("books/all")
//    public ResponseEntity<List<Book>> getAllBook() {
//        return  bookHelper.getAllBook();
//    }
//    @GetMapping("posts/all")
//    public ResponseEntity<List<Post>> getAllPost() {
//        return  postHelper.getAllPost();
//    }
//
//    @GetMapping("postDetail/all")
//    public ResponseEntity<?> getAllPostDetail() {
//        return  postHelper.getAllPostDetail();
//    }
//    @GetMapping("/books/{id}")
//    public ResponseEntity<Book> getBookById(@PathVariable("id") Integer id) {
//        return bookHelper.getById(id);
//    }
//    @GetMapping("/posts/{id}")
//    public ResponseEntity<Post> getPostById(@PathVariable("id") Integer id) {
//        return postHelper.getById(id);
//    }
//    @PostMapping("/add")
//    public ResponseEntity<?> addPost(@RequestBody Book book) {
//        return  ResponseEntity.ok(bookHelper.addBook(book));
//    }
//
//    @PutMapping("/update")
//    public ResponseEntity<?> updatePost(@RequestBody Book book) {
//        return  ResponseEntity.ok(bookHelper.updateBook(book));
//    }
////    @PostMapping("/login")
////    public ResponseEntity<User> loginUser(@RequestBody User user) throws Exception {
////        return ResponseEntity.ok(userHelper.login(user));
////    }
//    @PostMapping("/upload-file")
//    public String uploadimage(@RequestParam("file")MultipartFile file) throws IOException {
//        System.out.println(file.getOriginalFilename());
//        System.out.println(file.getName());
//        System.out.println(file.getContentType());
//        System.out.println(file.getSize());
//        String path_Directory = "D:\\book exchange\\src\\main\\resources\\static\\image";
////        String path_Directory = new ClassPathResource("resources/static/image/").getFile().getAbsolutePath();
//        Files.copy(file.getInputStream(), Paths.get(path_Directory+ File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
//        return "Successfully upload";
//    }
//
////    @DeleteMapping("/delete/{id}")
////    public ResponseEntity<Post> deletePost(@PathVariable Integer id) {
////        postService.deletePost(id);
////        return new ResponseEntity<>(HttpStatus.OK);
////    }
//}
