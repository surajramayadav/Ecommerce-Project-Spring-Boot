package com.adminpanel.adminpanel.services;

import com.adminpanel.adminpanel.models.CartModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface CartService {

    public List<Map<String, String>> getCart();
    public List<Map<String, String>> getCartByUserId(long user_id);
    public HashMap<String,Boolean> updateCart(long cart_id,long cart_quantity);
    public HashMap<String,Boolean> addCart(long user_id,long product_id,long cart_quantity);
    public HashMap<String,Boolean> deleteCart(long cart_id);
    public List<Map<String, String>> getCartByCartId(long cart_id);
}
