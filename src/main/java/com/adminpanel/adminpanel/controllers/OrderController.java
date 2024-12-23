package com.adminpanel.adminpanel.controllers;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    @GetMapping("/view")
    public String getOrder(){
        return "get order";
    }

    @GetMapping("/view/{id}")
    public String getOrderById(){
        return "get order byn id";
    }

    @PutMapping("/update/{id}")
    public String updateOrder(){
        return "update order";
    }

    @PostMapping("/add/{id}")
    public String addOrder(){
        return "add order";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteOrder(){
        return "add order";
    }
}
