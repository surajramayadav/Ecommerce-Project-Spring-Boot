package com.adminpanel.adminpanel.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "payment")
public class PaymentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long payment_id;

    @Column(name = "payment_status")
    private boolean payment_status;

    @ManyToOne
    @JoinColumn(name = "user_",nullable = false)
    private CartModel cartModel;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;


    public PaymentModel() {}

    public PaymentModel(boolean payment_status, CartModel cartModel,Date timestamp) {
        this.payment_status = payment_status;
        this.cartModel = cartModel;
        this.timestamp = timestamp;
    }



    public boolean isPayment_status() {
        return payment_status;
    }

    public void setPayment_status(boolean payment_status) {
        this.payment_status = payment_status;
    }

    public CartModel getCartModel() {
        return cartModel;
    }

    public void setCartModel(CartModel cartModel) {
        this.cartModel = cartModel;
    }

    public long getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(long payment_id) {
        this.payment_id = payment_id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return  "Payment [payment_id="+payment_id+",payment_status="+payment_status+",cartModel="+cartModel+",timestamp="+timestamp+"]";
    }
}
