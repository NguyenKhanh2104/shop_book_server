package com.example.api_shop_book.helper;

import com.example.api_shop_book.dto.CheckoutDTO;
import com.example.api_shop_book.mapper.OrderMapper;
import com.example.api_shop_book.model.Checkout;
import com.example.api_shop_book.model.Checkout_Item;
import com.example.api_shop_book.services.CheckoutItemService;
import com.example.api_shop_book.services.CheckoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderHelp {
    @Autowired
    CheckoutItemService checkoutItemService;
    @Autowired
    CheckoutService checkoutService;
    @Autowired
    OrderMapper orderMapper;
    public List<CheckoutDTO> getAllOrder() {
        List<Checkout> listCheckout = checkoutService.listCheckout();
        List<CheckoutDTO> rs = new ArrayList<>();
        for (Checkout ch: listCheckout) {
            CheckoutDTO orderDto  = orderMapper.toDto(ch);
            rs.add(orderDto);
        }

        return rs;
    }
    public List<Checkout_Item> getbyCheckoutId(long checkoutId){
        return checkoutItemService.getCheckoutId(checkoutId);
    }

    public static void main(String[] args) {
        OrderHelp o = new OrderHelp();
        System.out.println(o.getbyCheckoutId(24752));
    }
}
