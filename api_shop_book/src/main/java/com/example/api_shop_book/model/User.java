package com.example.api_shop_book.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "phone", length = 10)
    private String phone;


    @Column(name = "fullname")
    private String fullname;

    @Column(name = "img")
    private String img;

    @Column(name = "address")
    private String address;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "sex")
    private String sex;

    @Column(name = "position")
    private String position;

    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new LinkedHashSet<>();



    public User(String username, String email, String password,String phone) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone=phone;

    }

    public User(String username, String password, String email, String phone, String fullname, String img, String address, Date birthday, String sex, String position) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.fullname = fullname;
        this.img = img;
        this.address = address;
        this.birthday = birthday;
        this.sex = sex;
        this.position = position;
    }

    public User(Integer id, String email, String phone, String fullname, String address, Date birthday) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.fullname = fullname;
        this.address = address;
        this.birthday = birthday;
    }

    public User(Integer id, String email, String phone, String fullname, String address) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.fullname = fullname;
        this.address = address;
    }

    public User(Integer id, String fullname, String email, String phone) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
    }
}