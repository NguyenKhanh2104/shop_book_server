package com.example.api_shop_book.controllers;

import com.example.api_shop_book.dto.BookDTO;
import com.example.api_shop_book.dto.CheckoutDTO;
import com.example.api_shop_book.helper.BookHelper;
import com.example.api_shop_book.helper.OrderHelp;
import com.example.api_shop_book.helper.UserHelper;
import com.example.api_shop_book.model.Book;
import com.example.api_shop_book.model.Checkout_Item;
import com.example.api_shop_book.model.User;
import com.example.api_shop_book.services.CheckoutItemService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/admin")
public class PrivateController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private final UserHelper userHelper;
    @Autowired
    private final BookHelper bookHelper;
    @Autowired
    private final OrderHelp orderHelp;
    @Autowired
    CheckoutItemService checkoutItemService;
    @GetMapping("/user")
    public ResponseEntity<?> getAllUser() {
        return userHelper.getAllUser();
    }

    @GetMapping("/order")
    public List<CheckoutDTO> getAllOrder() {
        return orderHelp.getAllOrder();
    }

    @PostMapping(value = "/addUser", consumes = {"application/json"})
    public ResponseEntity<?> createUser(@Valid @RequestBody User user) {

        return userHelper.createUser(user);
    }
    @GetMapping("/findByCheckoutId/{id}")
    public List<Checkout_Item> getBycheckoutId(@PathVariable(value = "id") long id) throws Exception {
        return checkoutItemService.getCheckoutId(id);
    }
    @GetMapping("/findUserId/{id}")
    public ResponseEntity<?> getUserId(@PathVariable(value = "id") Integer userId) throws Exception {
        return userHelper.findId(userId);
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<?> updateUser(@PathVariable(value = "id") Integer userId,
                                        @Valid @RequestBody User userDetail) throws Exception {
        System.out.println(userDetail.getFullname());
        return userHelper.updateUser(userId, userDetail);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable(value = "id") Integer userId) {
        userHelper.deteleUser(userId);
    }

    @PutMapping("/updateBook/{id}")
    public ResponseEntity<?> updateBook(@PathVariable(value = "id") Integer id,
                                        @Valid @RequestBody Book bookDetail) throws Exception {
        return bookHelper.updateBook(id, bookDetail);
    }

    @DeleteMapping("/deleteBook/{id}")
    public void deleteBook(@PathVariable(value = "id") Integer id) {
        bookHelper.deteleBook(id);
    }

    @PostMapping(value = "/addBook", consumes = {"application/json"})
    public ResponseEntity<?> createBook(@Valid @RequestBody BookDTO bookDto) {
//        Book bookRequest = modelMapper.map(bookDto, Book.class);
//        Book book = new Book()
        return bookHelper.createBook(bookDto);
    }

    @GetMapping("/mod")
    public String moderatorAccess() {
        return "Moderator Board.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }
}
