package com.example.api_shop_book.services.Impl;

import com.example.api_shop_book.model.Checkout;
import com.example.api_shop_book.repository.AddToCartRepo;
import com.example.api_shop_book.repository.CheckoutRepository;
import com.example.api_shop_book.services.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckoutServiceImpl implements CheckoutService {
    @Autowired
    AddToCartRepo addCartRepo;
    @Autowired
    CartSerivceImpl cartService;
    @Autowired
    CheckoutRepository checkoutRepo;
    @Override
    public Boolean checkTotalAmountAgainstCart(double totalAmount, Integer userId) {
        double total_amount = addCartRepo.getTotalAmountByUserId(userId);
        if (total_amount == totalAmount) {
            return true;
        }
        System.out.print("Error from request " + total_amount + " --db-- " + totalAmount);
        return false;
    }
    @Override
    public List<Checkout> saveProductsForCheckout(List<Checkout> tmp) throws Exception {
        try {
            Integer user_id = tmp.get(0).getUser_id();

            if (tmp.size() > 0) {
                checkoutRepo.saveAll(tmp);

                cartService.removeAllCartByUserId(user_id);
                return this.getAllCheckoutByUserId(user_id);
            } else {
                throw new Exception("Should not be empty");
            }
        } catch (Exception e) {
            throw new Exception("Error while checkout " + e.getMessage());
        }
    }

    @Override
    public List<Checkout> getAllCheckoutByUserId(Integer userId) {
        return checkoutRepo.getByuserId(userId);
    }
    @Override
    public List<Checkout> findByOrder_id(String order_id) {
        return checkoutRepo.findByorder_id(order_id);
    }
}
