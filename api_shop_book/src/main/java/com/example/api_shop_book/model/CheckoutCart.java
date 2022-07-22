package com.example.api_shop_book.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@Table(name="checkout")
public class CheckoutCart {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	String order_id,payment_type,delivery_address;
	Integer user_id;
	@OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "book_id")
	Book book;
	int qty;
	double price;
	@Column(updatable=false, insertable=false)
	String order_date;

	
	
}
