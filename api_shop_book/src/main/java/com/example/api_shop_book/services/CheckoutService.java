package com.example.api_shop_book.services;

import com.example.api_shop_book.model.Checkout;

import java.util.List;

public interface CheckoutService {
     Boolean checkTotalAmountAgainstCart(double totalAmount, Integer userId);
    Checkout saveProductsForCheckout(Checkout tmp) throws Exception;
     List<Checkout> getAllCheckoutByUserId(Integer userId);
     List<Checkout> listCheckout();
     Checkout getById(long id);
}
