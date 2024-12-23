package com.adminpanel.adminpanel.controllers;


import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/api/v1/payment")
public class PaymentController {

    @GetMapping("/view")
    public String getPayment() {
        return  "get paymebnt";
    }

    @GetMapping("/view/{id}")
    public String getPaymentById() {
        return  "get paymebnt";
    }


    @PutMapping("/update/{id}")
    public String updatePayment() {
        return  "update paymebnt";
    }


    @PostMapping("/add")
    public String addPayment() {
        return  "add paymebnt";
    }

    @DeleteMapping("/delete/{id}")
    public String deletePayment() {
        return  "delete paymebnt";
    }


}
