package com.adminpanel.adminpanel.services;

import com.adminpanel.adminpanel.models.CartModel;

import java.util.HashMap;
import java.util.Optional;

public interface CartService {

    public Optional<CartModel> getCart();
    public CartModel updateCart();
    public HashMap<String,Boolean> addCart(long user_id,long product_id);
    public HashMap<String,Boolean> deleteCart();
}
