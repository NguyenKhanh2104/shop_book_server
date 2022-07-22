package com.example.api_shop_book.controllers;

import com.example.api_shop_book.dto.BookDTO;
import com.example.api_shop_book.helper.BookHelper;
import com.example.api_shop_book.model.AddtoCart;
import com.example.api_shop_book.payload.response.ApiResponse;
import com.example.api_shop_book.security.jwt.ShoppingConfiguration;
import com.example.api_shop_book.services.CheckoutService;
import com.example.api_shop_book.services.Impl.BookServiceImpl;
import com.example.api_shop_book.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
//@RequestMapping("/api/public/books")
@RequestMapping("/api/public/")
public class PublicController {
    private final BookHelper bookHelper;
    @Autowired
    CartService cartService;
    @Autowired
    private BookServiceImpl bookService;
    @Autowired
    CheckoutService checkoutService;
    @GetMapping("/allBook")
    public List<BookDTO> getAllBook() {
        return bookHelper.getAllBook();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable("id") Integer id) throws Exception {
        return bookHelper.getBookById(id);
    }
    @RequestMapping("getCartsByUserId")
    public ResponseEntity<?> getCartsByUserId(@RequestBody HashMap<String,String> getCartRequest) {
        try {
            String keys[] = {"userId"};
            if(ShoppingConfiguration.validationWithHashMap(keys, getCartRequest)) {
            }
            List<AddtoCart> obj = cartService.getCartByUserId(Integer.parseInt(getCartRequest.get("userId")));
            return ResponseEntity.ok(obj);
        }catch(Exception e) {
            return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
        }
    }

//
//    @PostMapping("/add")
//    public ResponseEntity<?> addPost(@RequestBody Book book) {
//        return  ResponseEntity.ok(bookHelper.addBook(book));
//    }
//
//    @PutMapping("/update")
//    public ResponseEntity<?> updatePost(@RequestBody Book book) {
//        return  ResponseEntity.ok(bookHelper.updateBook(book));
//    }
//    @PostMapping("/login")
//    public ResponseEntity<User> loginUser(@RequestBody User user) throws Exception {
//        return ResponseEntity.ok(userHelper.login(user));
//    }
//    @PostMapping("/upload-file")
//    public String uploadimage(@RequestParam("file")MultipartFile file) throws IOException {
//        System.out.println(file.getOriginalFilename());
//        System.out.println(file.getName());
//        System.out.println(file.getContentType());
//        System.out.println(file.getSize());
//        String path_Directory = "D:\\book exchange\\src\\main\\resources\\static\\image";
//        String path_Directory = new ClassPathResource("resources/static/image/").getFile().getAbsolutePath();
//        Files.copy(file.getInputStream(), Paths.get(path_Directory+ File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
//        return "Successfully upload";
//    }

//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Post> deletePost(@PathVariable Integer id) {
//        postService.deletePost(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
