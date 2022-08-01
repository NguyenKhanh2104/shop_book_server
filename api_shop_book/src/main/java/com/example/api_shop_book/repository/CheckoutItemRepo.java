package com.example.api_shop_book.repository;

import com.example.api_shop_book.model.Checkout;
import com.example.api_shop_book.model.Checkout_Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CheckoutItemRepo extends JpaRepository<Checkout_Item,Integer> {
    @Query("Select checkCart  FROM Checkout_Item checkCart WHERE checkCart.checkout=:checkout")
    List<Checkout_Item> getByCheckout(@Param("checkout")String checkout);
    @Query("Select checkCart FROM Checkout_Item checkCart WHERE checkCart.checkout.user_id=:user_id")
    List<Checkout_Item> getByUserId(@Param("user_id")Integer user_id);

}
