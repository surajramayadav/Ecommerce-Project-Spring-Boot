package com.adminpanel.adminpanel.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "cart")
public class CartModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cart_id;
    @OneToOne
    @JoinColumn(name = "user_id",nullable = false)
    private UserModel userModel;


    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;


    public CartModel() {}

    public CartModel(UserModel userModel, Date timestamp) {
        this.userModel = userModel;

        this.timestamp = timestamp;
    }

    public long getCart_id() {
        return cart_id;
    }

    public void setCart_id(long cart_id) {
        this.cart_id = cart_id;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }



    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }



    @Override
    public String toString() {
        return  "Cart [cart_id="+cart_id+",userModel="+userModel+",timestamp="+timestamp+"]";
    }
}
