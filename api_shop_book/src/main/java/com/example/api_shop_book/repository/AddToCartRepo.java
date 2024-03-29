package com.example.api_shop_book.repository;

import com.example.api_shop_book.model.AddtoCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface AddToCartRepo extends JpaRepository<AddtoCart,Long> {

	@Query("Select sum(addCart.price) FROM AddtoCart addCart WHERE addCart.user_id=:user_id")
	double getTotalAmountByUserId(@Param("user_id")Integer user_id);

	@Query("Select addCart  FROM AddtoCart addCart WHERE addCart.user_id=:user_id")
	List<AddtoCart> getCartByUserId(@Param("user_id")Integer user_id);


	@Query("Select addCart  FROM AddtoCart addCart WHERE addCart.book.id=:book_id")
	AddtoCart getCartByBookId(@Param("book_id")Integer book_id);


	@Query("Select addCart  FROM AddtoCart addCart ")
	Optional<AddtoCart> getCartByuserIdtest();
	@Query("Select addCart  FROM AddtoCart addCart WHERE addCart.book.id= :book_id and addCart.user_id=:user_id")
	Optional<AddtoCart> getCartByBookIdAnduserId(@Param("user_id")Integer user_id,@Param("book_id")Integer book_id);
	@Modifying
    @Transactional
	@Query("DELETE  FROM AddtoCart addCart WHERE addCart.id =:cart_id  and addCart.user_id=:user_id")
	void deleteCartByIdAndUserId(@Param("user_id")Integer user_id,@Param("cart_id")Long cart_id);
	@Modifying
    @Transactional
	@Query("DELETE  FROM AddtoCart addCart WHERE   addCart.user_id=:user_id")
	void deleteAllCartByUserId(@Param("user_id")Integer user_id);

	@Modifying
    @Transactional
	@Query("DELETE  FROM AddtoCart addCart WHERE addCart.user_id=:user_id")
	void deleteAllCartUserId(@Param("user_id")Integer user_id);
	@Modifying
    @Transactional
	@Query("update AddtoCart addCart set addCart.qty=:qty,addCart.price=:price WHERE addCart.id=:cart_id")
	void updateQtyByCartId(@Param("cart_id")Long cart_id,@Param("price")double price,@Param("qty")Integer qty);
	@Modifying
	@Transactional
	@Query("update AddtoCart addCart set addCart.qty=:qty,addCart.price=:price WHERE addCart.book.id=:book_id")
	void updateQtyByBookId(@Param("book_id")Integer book_id,@Param("price")double price,@Param("qty")Integer qty);

}
