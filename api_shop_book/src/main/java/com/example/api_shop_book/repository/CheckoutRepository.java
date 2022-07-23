package com.example.api_shop_book.repository;

import com.example.api_shop_book.model.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CheckoutRepository extends JpaRepository<Checkout, Long> {
	@Query("Select checkCart  FROM Checkout checkCart WHERE checkCart.user_id=:user_id")
	List<Checkout> getByuserId(@Param("user_id")Integer user_id);
	@Query("Select checkCart  FROM Checkout checkCart WHERE checkCart.order_id=:order_id")
	List<Checkout> findByorder_id(@Param("order_id")String order_id);

}
