package com.example.api_shop_book.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Entity
@Getter
@Setter
@Table(name="checkout")
public class Checkout {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	Boolean status;
	String note;
	String order_id,payment_type,delivery_address;
	Integer user_id;
	@OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "book_id")
	Book book;
	//long ;
	int qty;
	double price;
	Date order_date;
	
	
}
