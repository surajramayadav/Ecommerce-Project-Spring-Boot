package com.adminpanel.adminpanel.models;

import jakarta.persistence.*;

@Entity
@Table(name = "cartItems")
public class CartProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartItems_id;

    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
    private ProductModel product;

    @ManyToOne
    @JoinColumn(name = "cart_id",nullable = false)
    private CartModel cart;

    @Column(name = "cart_quantity",nullable = false)
    private long cart_quantity;

    public  CartProductModel() {}

    public CartProductModel(ProductModel product, long cart_quantity, CartModel cart) {
        this.product = product;
        this.cart_quantity = cart_quantity;
        this.cart = cart;
    }

    public long getCartItems_id() {
        return cartItems_id;
    }

    public void setCartItems_id(long cartItems_id) {
        this.cartItems_id = cartItems_id;
    }

    public ProductModel getProduct() {
        return product;
    }

    public CartModel getCart() {
        return cart;
    }

    public void setCart(CartModel cart) {
        this.cart = cart;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
    }

    public long getCart_quantity() {
        return cart_quantity;
    }

    public void setCart_quantity(long cart_quantity) {
        this.cart_quantity = cart_quantity;
    }

    @Override
    public String toString() {
        return  "CartProduct [cartItems_id="+cartItems_id+",product="+product+",cart_quantity="+cart_quantity+",cart="+cart+"]";
    }
}
