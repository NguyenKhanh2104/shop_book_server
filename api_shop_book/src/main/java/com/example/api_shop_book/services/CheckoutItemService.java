package com.example.api_shop_book.services;

import com.example.api_shop_book.model.Checkout_Item;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CheckoutItemService {
    List<Checkout_Item> saveCheckoutItem(List<Checkout_Item> checkout_item);
    Checkout_Item save(Checkout_Item checkout_item);
    List<Checkout_Item> list();
    List<Checkout_Item> getByCheckoutId(String checkoutId);
    List<Checkout_Item> getCheckoutId(long checkout);
}
