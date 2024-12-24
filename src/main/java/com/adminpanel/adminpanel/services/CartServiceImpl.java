package com.adminpanel.adminpanel.services;

import com.adminpanel.adminpanel.exception.ResourceNotFoundException;
import com.adminpanel.adminpanel.models.CartModel;
import com.adminpanel.adminpanel.models.CartProductModel;
import com.adminpanel.adminpanel.models.ProductModel;
import com.adminpanel.adminpanel.models.UserModel;
import com.adminpanel.adminpanel.repository.CartProductRepository;
import com.adminpanel.adminpanel.repository.CartRepository;
import com.adminpanel.adminpanel.repository.ProductRepository;
import com.adminpanel.adminpanel.repository.UserRepository;
import com.adminpanel.adminpanel.utils.ApiResponse;
import jakarta.persistence.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    CartProductRepository cartProductRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;



    ApiResponse apiResponse=new ApiResponse();

    @Override
    public List<Map<String, String>> getCart() {
        return cartRepository.getCart();
    }

    @Override
    public List<Map<String, String>> getCartByUserId(long user_id) {
        return cartRepository.getCartByUserId(user_id);
    }

    public List<Map<String, String>> getCartByCartId(long cart_id) {
        return cartRepository.getCartByCartId(cart_id);
    }


    @Override
    public HashMap<String,Boolean> updateCart(long cart_id,long cart_quantity) {
        if(cart_quantity==0){
            cartRepository.deleteById(cart_id);
        }else{
            int flag=cartRepository.updateCartQuantity(cart_quantity,cart_id);
           if(flag==1){
               return  apiResponse.addKeyValue(true);
           }else{
              return apiResponse.addKeyValue(true);
           }
        }
        return null;
    }

    @Override
    public HashMap<String,Boolean> addCart(long user_id,long product_id,long cart_quantity) {
        long cart_id = 0;
        List<Tuple> isCartExits = cartRepository.getUserBycart(user_id);
        CartModel newCart =new CartModel();

        if(isCartExits.isEmpty()){
            System.out.println("inside");
            UserModel user=userRepository.getById(user_id);
            CartModel cart=new CartModel();
            cart.setUserModel(user);
            newCart=cartRepository.save(cart);
        }else{
            cart_id= (long) isCartExits.get(0).get(0);
        }
        System.out.println("outside");
        ProductModel product=productRepository.getById(product_id);
       
        newCart=cartRepository.getById(cart_id);
        CartProductModel cartProduct=new CartProductModel();
        cartProduct.setCart(newCart);
        cartProduct.setProduct(product);

        cartProduct.setCart_quantity(cart_quantity);

        cartProductRepository.save(cartProduct);

        return apiResponse.addKeyValue(true);
    }

    @Override
    public HashMap<String, Boolean> deleteCart(long cart_id) {
        Optional<CartProductModel> cart=cartProductRepository.findById(cart_id);
        if(cart.isEmpty()){
            throw new ResourceNotFoundException("cart not found");
        }
        cartProductRepository.deleteById(cart_id);
        Optional<CartProductModel> newCart=cartProductRepository.findById(cart_id);
        if(newCart.isPresent()){
            return apiResponse.addKeyValue(false);
        }
        return apiResponse.addKeyValue(true);
    }
}
