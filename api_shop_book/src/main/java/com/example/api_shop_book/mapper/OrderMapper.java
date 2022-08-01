package com.example.api_shop_book.mapper;

import com.example.api_shop_book.dto.CheckoutDTO;
import com.example.api_shop_book.model.Checkout;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public CheckoutDTO toDto(Checkout checkout) {
        CheckoutDTO newOrder = new CheckoutDTO();
        newOrder.setIdOrder(checkout.getId());
        newOrder.setUser_id(checkout.getUser_id());
        newOrder.setStatus(false);
        newOrder.setDateCreate(checkout.getDateCreate());
        newOrder.setDelivery_address(checkout.getDelivery_address());
        newOrder.setNote(checkout.getNote());
        newOrder.setPayment_type(checkout.getPayment_type());
        newOrder.setTotalPrice(checkout.getTotalPrice());

        return newOrder;
    }
}
