package com.example.api_shop_book.controllers;

import com.example.api_shop_book.model.AddtoCart;
import com.example.api_shop_book.model.Checkout;
import com.example.api_shop_book.model.Checkout_Item;
import com.example.api_shop_book.payload.response.ApiResponse;
import com.example.api_shop_book.repository.CheckoutItemRepo;
import com.example.api_shop_book.security.jwt.ShoppingConfiguration;
import com.example.api_shop_book.services.CartService;
import com.example.api_shop_book.services.CheckoutItemService;
import com.example.api_shop_book.services.CheckoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerError;
import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order/")
public class CheckoutController {
    @Autowired
    CheckoutService checkoutService;
    @Autowired
    CheckoutItemRepo checkoutItemRepo;
    @Autowired
    CheckoutItemService checkoutItemService;
    @Autowired
    CartService cartService;

    @RequestMapping("checkout_order")
    public ResponseEntity<?> checkout_order(@RequestBody HashMap<String, String> addCartRequest) {
        try {
            String keys[] = {"userId", "total_price", "pay_type", "deliveryAddress", "note"};
            if (ShoppingConfiguration.validationWithHashMap(keys, addCartRequest)) {

            }
            Integer user_Id = Integer.parseInt(addCartRequest.get("userId"));
            double total_amt = Double.parseDouble(addCartRequest.get("total_price"));
            if (checkoutService.checkTotalAmountAgainstCart(total_amt, user_Id)) {
                double total = 0;
                List<AddtoCart> cartItems = cartService.getCartByUserId(user_Id);
                for (AddtoCart a:cartItems
                     ) {
                    System.err.println("tron gio hang co "+ a);
                }
                List<Checkout_Item> tmp = new ArrayList<>();
                List<Checkout> listCheckout = new ArrayList<>();
                Checkout checkout = new Checkout();
                int orderId = getOrderId();
                checkout.setUser_id(user_Id);
                checkout.setId(orderId);
                checkout.setNote(addCartRequest.get("note"));
                checkout.setPayment_type(addCartRequest.get("pay_type"));
                Date date = new Date();
                checkout.setDateCreate(date);
                checkout.setDelivery_address(addCartRequest.get("deliveryAddress"));
               checkout =  checkoutService.saveProductsForCheckout(checkout);
                for (AddtoCart addCart : cartItems) {
                    Checkout_Item checkout_item = new Checkout_Item();

                    checkout_item.setPrice(addCart.getPrice());
                    checkout_item.setBook(addCart.getBook());

                    checkout_item.setQty(addCart.getQty());

                    checkout_item.setCheckout(checkout);

                    total += addCart.getPrice();
                    tmp.add(checkout_item);
                }
                checkout.setTotalPrice(total);
                checkout.setCheckoutItem(tmp);
//                checkoutItemService.saveCheckoutItem(tmp);
                for (Checkout_Item c : tmp
                ) {

                    checkoutItemService.save(c);
                    System.err.println("phan tu da them " + c);
                }

                checkoutService.saveProductsForCheckout(checkout);
                cartService.removeAllCartByUserId(user_Id);
                checkoutService.getAllCheckoutByUserId(user_Id);
                System.out.println("da xoa cart");
                return ResponseEntity.ok(new ApiResponse("Order placed successfully", ""));
            } else {
                throw new Exception("Total amount is mismatch");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
        }
    }

    public int getOrderId() {
        Random r = new Random(System.currentTimeMillis());
        return 10000 + r.nextInt(20000);
    }

    @RequestMapping("getOrdersByUserId")
    public ResponseEntity<?> getOrdersByUserId(@RequestBody HashMap<String, String> ordersRequest) {
        try {
            String keys[] = {"userId"};
            return ResponseEntity.ok(new ApiResponse("Order placed successfully", ""));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
        }

    }

    @GetMapping("/findByUserId/{userid}")
    public ResponseEntity<?> getCheckoutCartByUserId(@PathVariable("userid") Integer userid) throws Exception {
        List<Checkout> list = checkoutService.getAllCheckoutByUserId(userid);
        List<Checkout> newList = new ArrayList<>();
        for (Checkout checkout : list
        ) {
            newList.add(checkout);
        }
        return ResponseEntity.ok(newList);
    }

//    @GetMapping("/findByOrderId/{orderid}")
//    public ResponseEntity<?> getCheckoutCartByOrderId(@PathVariable("orderid") String orderid) throws Exception {
//        List<Checkout> list = checkoutService.findByOrder_id(orderid);
//        List<Checkout> newList = new ArrayList<>();
//        for (Checkout checkout : list
//        ) {
//            newList.add(checkout);
//        }
//        return ResponseEntity.ok(newList);
//    }
}
