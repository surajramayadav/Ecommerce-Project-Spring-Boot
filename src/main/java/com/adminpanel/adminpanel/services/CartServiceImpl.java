package com.adminpanel.adminpanel.services;

import com.adminpanel.adminpanel.models.CartModel;
import com.adminpanel.adminpanel.models.ProductModel;
import com.adminpanel.adminpanel.models.UserModel;
import com.adminpanel.adminpanel.repository.CartRepository;
import com.adminpanel.adminpanel.repository.ProductRepository;
import com.adminpanel.adminpanel.repository.UserRepository;
import com.adminpanel.adminpanel.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    ApiResponse apiResponse=new ApiResponse();

    @Override
    public Optional<CartModel> getCart() {
        return Optional.empty();
    }

    @Override
    public CartModel updateCart() {
        return null;
    }

    @Override
    public HashMap<String,Boolean> addCart(long user_id,long product_id) {
        UserModel user=userRepository.getById(user_id);
        ProductModel product=productRepository.getById(product_id);
        CartModel cart=new CartModel();
        cart.setUserModel(user);
        cart.setProductModel(product);

        cartRepository.save(cart);

        return apiResponse.addKeyValue(true);
    }

    @Override
    public HashMap<String, Boolean> deleteCart() {
        return null;
    }
}
