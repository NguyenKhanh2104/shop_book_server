package com.example.api_shop_book.mapper;

import com.example.api_shop_book.model.AddtoCart;
import com.example.api_shop_book.model.Book;
import com.example.api_shop_book.payload.response.BookResponse;
import com.example.api_shop_book.payload.response.CartResponse;

public class CartMapper {
    public static CartResponse toCartResp(AddtoCart addtoCart) {
        CartResponse cartResp = new CartResponse();

        cartResp.setId(addtoCart.getId());
        cartResp.setNameBook(addtoCart.getBook().getName());
        cartResp.setQty(addtoCart.getQty());
        cartResp.setPrice(addtoCart.getPrice());
        cartResp.setBookId(addtoCart.getBook().getId());
        cartResp.setAdded_date(addtoCart.getAdded_date());
        cartResp.setUser_id(addtoCart.getUser_id());


        return cartResp;
    }
}
