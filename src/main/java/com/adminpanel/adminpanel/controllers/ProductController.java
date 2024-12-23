package com.adminpanel.adminpanel.controllers;


import com.adminpanel.adminpanel.models.ProductModel;
import com.adminpanel.adminpanel.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/view")
    public ResponseEntity<List<ProductModel>> getProduct(){
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<ProductModel> getProductById(@PathVariable long id){
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProductModel> updateProduct(@PathVariable long id, @RequestBody ProductModel productModel){
        return new ResponseEntity<>(productService.updateProduct(id,productModel), HttpStatus.OK);
    }

    @PatchMapping("/update/quantity/{id}")
    public ResponseEntity<ProductModel> updateProductQuantity(@PathVariable long id, @RequestBody ProductModel productModel){
        return new ResponseEntity<>(productService.updateProductQuantity(id,productModel), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ProductModel> addProduct(@RequestBody ProductModel productModel){
        return new ResponseEntity<>(productService.addProduct(productModel), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HashMap<String,Boolean>> deleteProduct(@PathVariable long id){
        return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK);
    }
}
