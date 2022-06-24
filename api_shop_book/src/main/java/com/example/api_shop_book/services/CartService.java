package com.example.api_shop_book.services;

import com.example.api_shop_book.model.AddtoCart;
import com.example.api_shop_book.model.CheckoutCart;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CartService {
	List<AddtoCart> addCartbyUserIdAndBookId(Integer bookId, Integer userId, int qty, double price) throws Exception;
	void updateQtyByCartId(long cartId,int qty,double price) throws Exception;
	List<AddtoCart> getCartByUserId(Integer userId);
	List<AddtoCart> removeCartByUserId(long cartId,Integer userId);
	List<AddtoCart> removeAllCartByUserId(Integer userId);
	Boolean checkTotalAmountAgainstCart(double totalAmount,Integer userId);
	List<CheckoutCart> getAllCheckoutByUserId(Integer userId);
	List<CheckoutCart> saveProductsForCheckout(List<CheckoutCart> tmp)  throws Exception;
	
	
	//CheckOutCart
}
