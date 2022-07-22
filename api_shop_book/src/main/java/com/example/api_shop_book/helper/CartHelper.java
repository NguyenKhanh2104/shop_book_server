package com.example.api_shop_book.helper;

import com.example.api_shop_book.dto.AddToCartDTO;
import com.example.api_shop_book.model.AddtoCart;
import com.example.api_shop_book.payload.response.ApiResponse;
import com.example.api_shop_book.security.jwt.ShoppingConfiguration;
import com.example.api_shop_book.services.CartService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.springframework.http.ResponseEntity.badRequest;

@Component
@RequiredArgsConstructor
public class CartHelper {
    @Autowired
    private ModelMapper modelMapper;

    private final CartService cartService;

//    public ResponseEntity<AddToCartDTO> addCartwithProduct(HashMap<String, String> addToCartdto) {
//        try {
//            String keys[] = {"bookId", "userId", "qty", "price"};
//            if (ShoppingConfiguration.validationWithHashMap(keys, addToCartdto)) {
//
//            }
//            Integer bookId = Integer.parseInt(addToCartdto.get("bookId"));
//            Integer userId = Integer.parseInt(addToCartdto.get("userId"));
//            int qty = Integer.parseInt(addToCartdto.get("qty"));
//            double price = Double.parseDouble(addToCartdto.get("price"));
//
//            AddtoCart addtoCartRequest = modelMapper.map(addToCartdto, AddtoCart.class);
//            addtoCartRequest.getBook().getId().equals(bookId);
//            addtoCartRequest.getUser_id().equals(userId);
//            addtoCartRequest.setQty(qty);
//            addtoCartRequest.setPrice(price);
//
//            List<AddtoCart> addtoCart = cartService.addCartbyUserIdAndBookId(addtoCartRequest);
//            List<AddToCartDTO> result = new ArrayList<>();
//            for (AddtoCart addtoCart1 : addtoCart
//                 ) {
//                result.add(this.modelMapper.map(addtoCart1,AddToCartDTO.class));
//            }
//
//            return ResponseEntity.ok(result);
//        } catch (Exception e) {
//            e.printStackTrace();
//
//            return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
//        }
//    }
    public ResponseEntity<?> removeCartwithProductId( HashMap<String,String> removeCartRequest) {
        try {
            String keys[] = {"userId","cartId"};
            if(ShoppingConfiguration.validationWithHashMap(keys, removeCartRequest)) {

            }

            List<AddtoCart> obj = cartService.removeCartByUserId(Long.parseLong(removeCartRequest.get("cartId")), Integer.parseInt(removeCartRequest.get("userId")));
            return ResponseEntity.ok(obj);
        }catch(Exception e) {
            return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
        }
    }
}
