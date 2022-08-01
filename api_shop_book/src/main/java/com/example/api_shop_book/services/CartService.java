package com.example.api_shop_book.services;

import com.example.api_shop_book.model.AddtoCart;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CartService {
	List<AddtoCart> findAll();
	List<AddtoCart> addCartbyUserIdAndBookId(Integer bookId, Integer userId, int qty, double price) throws Exception;
	void updateQtyByCartId(long cartId,int qty,double price) throws Exception;
	void updateQtyByBookId(Integer book_id,int qty,double price) throws  Exception;
	List<AddtoCart> getCartByUserId(Integer userId);
	AddtoCart getCartByBookId(Integer bookId);
	List<AddtoCart> removeCartByUserId(long cartId,Integer userId);
	List<AddtoCart> removeAllCartByUserId(Integer userId);
	
	
	//CheckOutCart
}
