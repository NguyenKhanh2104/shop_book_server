package com.example.api_shop_book.services.Impl;

import com.example.api_shop_book.model.Checkout;
import com.example.api_shop_book.model.Checkout_Item;
import com.example.api_shop_book.repository.AddToCartRepo;
import com.example.api_shop_book.repository.CheckoutRepository;
import com.example.api_shop_book.services.CartService;
import com.example.api_shop_book.services.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckoutServiceImpl implements CheckoutService {
    @Autowired
    AddToCartRepo addCartRepo;
    @Autowired
    CartService cartService;
    @Autowired
    CheckoutRepository checkoutRepo;

    @Override
    public Boolean checkTotalAmountAgainstCart(double totalAmount, Integer userId) {
        double total_amount = addCartRepo.getTotalAmountByUserId(userId);
        if (total_amount == totalAmount) {
            return true;
        }
        System.err.print("Error from request " + total_amount + " --db-- " + totalAmount);
        return false;
    }

    @Override
    public Checkout saveProductsForCheckout(Checkout tmp) throws Exception {
       return checkoutRepo.saveAndFlush(tmp);


    }

    @Override
    public List<Checkout> getAllCheckoutByUserId(Integer userId) {
        return checkoutRepo.getByuserId(userId);
    }

    @Override
    public List<Checkout> listCheckout() {
        return checkoutRepo.findAll();
    }

    @Override
    public Checkout getById(long id) {
        return checkoutRepo.getById(id);
    }

//    @Override
//    public List<Checkout> findByOrder_id(String order_id) {
//        return checkoutRepo.findByorder_id(order_id);
//    }
}
