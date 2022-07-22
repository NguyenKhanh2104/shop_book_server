package com.example.api_shop_book.services;

import com.example.api_shop_book.model.CheckoutCart;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CheckoutService {
     Boolean checkTotalAmountAgainstCart(double totalAmount, Integer userId);
    List<CheckoutCart> saveProductsForCheckout(List<CheckoutCart> tmp) throws Exception;
     List<CheckoutCart> getAllCheckoutByUserId(Integer userId);
}
