package com.example.api_shop_book.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Entity
@Getter
@Setter
@Table(name = "checkout")
public class Checkout {
    @Id
    @Column(name = "checkout_id")
    long id;
    @OneToMany(mappedBy = "checkout")
    private List<Checkout_Item> checkoutItem;
    Boolean status;
    String note;
    String payment_type, delivery_address;
        Integer user_id;
        double totalPrice;

        Date dateCreate;


}
