package com.example.api_shop_book.services.Impl;

import java.util.List;

import com.example.api_shop_book.model.AddtoCart;
import com.example.api_shop_book.model.Book;
import com.example.api_shop_book.repository.AddToCartRepo;
import com.example.api_shop_book.repository.CheckoutRepository;
import com.example.api_shop_book.services.CartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartSerivceImpl implements CartService {

    @Autowired
    AddToCartRepo addCartRepo;
    @Autowired
    CheckoutRepository checkOutRepo;
    @Autowired
    BookServiceImpl bookService;
    private static final Logger logger = LoggerFactory.getLogger(CartSerivceImpl.class);

    @Override
    public List<AddtoCart> addCartbyUserIdAndBookId(Integer bookId, Integer userId, int qty, double price) throws Exception {
        AddtoCart obj = new AddtoCart();
        int count = 1;
        try {
            if (addCartRepo.getCartByBookIdAnduserId(userId, bookId).isPresent()) {
                AddtoCart a = addCartRepo.getCartByBookId(bookId);
                addCartRepo.updateQtyByBookId(bookId, a.getBook().getPrice() * (a.getQty()+count), a.getQty() + count);
            } else {

                obj.setQty(qty);
                obj.setUser_id(userId);
                Book book = bookService.getBookById(bookId);
                obj.setBook(book);
                //TODO price has to check with qty
                obj.setPrice(price);
                addCartRepo.save(obj);

            }
            count++;
            System.err.println("count is after add " + count);
            return this.getCartByUserId(userId);

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("" + e.getMessage());
            throw new Exception(e.getMessage());
        }


    }

    public List<AddtoCart> getCartByUserId(Integer userId) {
        return addCartRepo.getCartByuserId(userId);
    }

    @Override
    public AddtoCart getCartByBookId(Integer bookId) {
        return addCartRepo.getCartByBookId(bookId);
    }

    public List<AddtoCart> removeCartByUserId(long cartId, Integer userId) {
        addCartRepo.deleteCartByIdAndUserId(userId, cartId);
        return this.getCartByUserId(userId);

    }

    @Override
    public void updateQtyByCartId(long cartId, int qty, double price) throws Exception {
        addCartRepo.updateQtyByCartId(cartId, price, qty);
    }

    @Override
    public void updateQtyByBookId(Integer book_id, int qty, double price) throws Exception {
        addCartRepo.updateQtyByBookId(book_id, price, qty);
    }
    @Override
    public List<AddtoCart> removeAllCartByUserId(Integer userId) {
        addCartRepo.deleteAllCartByUserId(userId);
        return null;
    }

}
