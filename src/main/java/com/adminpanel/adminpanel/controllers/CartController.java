package com.adminpanel.adminpanel.controllers;

import com.adminpanel.adminpanel.models.CartModel;
import com.adminpanel.adminpanel.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping("/view/{user_id}")
    public ResponseEntity<Optional<CartModel>> getCart(){
        return new ResponseEntity<>(cartService.getCart(), HttpStatus.OK);
    }

    @PutMapping("/update/{user_id}")
    public ResponseEntity<CartModel> updateCart(){
        return new ResponseEntity<>(cartService.updateCart(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<HashMap<String,Boolean>> addCart(@RequestBody HashMap<String,Long> cart){
        long userId=cart.get("user_id");
        long product_id=cart.get("product_id");
        return new ResponseEntity<>(cartService.addCart(userId,product_id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{user_id}")
    public ResponseEntity<HashMap<String,Boolean>> deleteCart(){
        return new ResponseEntity<>(cartService.deleteCart(), HttpStatus.OK);
    }


}
