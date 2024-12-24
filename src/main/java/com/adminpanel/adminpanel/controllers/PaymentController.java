package com.adminpanel.adminpanel.controllers;


import com.adminpanel.adminpanel.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController

@RequestMapping("/api/v1/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

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


    @PostMapping("")
    public ResponseEntity<HashMap<String,Boolean>> addPayment(@RequestBody Map<String,String> payment) {
        System.out.print(payment);
        long cart_id=Long.parseLong(payment.get("cart_id"));
        boolean payment_status=Boolean.parseBoolean(payment.get("payment_status"));
        return new ResponseEntity<>(paymentService.addPayment(cart_id,payment_status),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public String deletePayment() {
        return  "delete paymebnt";
    }


}
