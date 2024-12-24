package com.adminpanel.adminpanel.services;

import java.util.HashMap;

public interface PaymentService {

    public HashMap<String,Boolean> addPayment(long cart_id,boolean payment_status);
}
