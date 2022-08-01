package com.example.api_shop_book.services.Impl;

import com.example.api_shop_book.model.Checkout;
import com.example.api_shop_book.model.Checkout_Item;
import com.example.api_shop_book.repository.CheckoutItemRepo;
import com.example.api_shop_book.services.CartService;
import com.example.api_shop_book.services.CheckoutItemService;
import com.example.api_shop_book.services.CheckoutService;
import org.hibernate.annotations.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CheckoutItemServiceImpl implements CheckoutItemService {
    @Autowired
    CheckoutItemRepo checkoutItemRepo;
    @Autowired
    CartService cartService;
    @Autowired
    CheckoutService checkoutService;

    @Override
    public List<Checkout_Item> saveCheckoutItem(List<Checkout_Item> checkout_item) {
        for (int i = 0; i < checkout_item.size(); i++) {
            checkoutItemRepo.save(checkout_item.get(i));
            System.err.println("phan tu thu ");
        }
        return checkout_item;
    }

    @Override
    public Checkout_Item save(Checkout_Item checkout_item) {
        return checkoutItemRepo.save(checkout_item);
    }

    @Override
    public List<Checkout_Item> list() {
        return checkoutItemRepo.findAll();
    }

    @Override
    public List<Checkout_Item> getByCheckoutId(String checkoutId) {
        List<Checkout_Item> list = checkoutItemRepo.getByCheckout(checkoutId);
        List<Checkout_Item> newList = new ArrayList<>();
        for (Checkout_Item checkoutItem : list
        ) {
            newList.add(checkoutItem);
        }
        return newList;
    }

    @Override
    public List<Checkout_Item> getCheckoutId(long checkout) {
        List<Checkout_Item> listItem = checkoutItemRepo.findAll();
        List<Checkout_Item> rs = new ArrayList<>();
        for (Checkout_Item c : listItem
        ) {
            if (c.getCheckout().getId() == checkout) {
                rs.add(c);
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        CheckoutItemServiceImpl c = new CheckoutItemServiceImpl();
        System.out.println(c.getCheckoutId(24752));
    }
}
