package com.adminpanel.adminpanel.controllers;

import com.adminpanel.adminpanel.models.CartModel;
import com.adminpanel.adminpanel.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping("/view")
    public ResponseEntity<List<Map<String, String>>> getCart(){
        return new ResponseEntity<>(cartService.getCart(), HttpStatus.OK);
    }

    @GetMapping("/view/user/{user_id}")
    public ResponseEntity<List<Map<String, String>>> getCartByUserID(@PathVariable long user_id){
        return new ResponseEntity<>(cartService.getCartByUserId(user_id), HttpStatus.OK);
    }

    @GetMapping("/view/{cart_id}")
    public ResponseEntity<List<Map<String, String>>> getCartByCartID(@PathVariable long cart_id){
        return new ResponseEntity<>(cartService.getCartByCartId(cart_id), HttpStatus.OK);
    }

    @PutMapping("/update/{cart_item_id}")
    public ResponseEntity<HashMap<String,Boolean>> updateCart(@PathVariable long cart_item_id,@RequestBody HashMap<String,Long> cart){
        long cart_quantity=cart.get("cart_quantity");
        return new ResponseEntity<>(cartService.updateCart(cart_item_id,cart_quantity), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<HashMap<String,Boolean>> addCart(@RequestBody HashMap<String,Long> cart){
        long userId=cart.get("user_id");
        long product_id=cart.get("product_id");
        long cart_quantity=cart.get("cart_quantity");
        return new ResponseEntity<>(cartService.addCart(userId,product_id,cart_quantity), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{cart_id}")
    public ResponseEntity<HashMap<String,Boolean>> deleteCart(@PathVariable long cart_id){
        return new ResponseEntity<>(cartService.deleteCart(cart_id), HttpStatus.OK);
    }


}
