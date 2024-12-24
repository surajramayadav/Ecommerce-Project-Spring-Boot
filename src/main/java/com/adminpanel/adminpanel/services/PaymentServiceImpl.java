package com.adminpanel.adminpanel.services;

import com.adminpanel.adminpanel.models.CartModel;
import com.adminpanel.adminpanel.models.PaymentModel;
import com.adminpanel.adminpanel.repository.CartRepository;
import com.adminpanel.adminpanel.repository.PaymentRepository;
import com.adminpanel.adminpanel.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class PaymentServiceImpl implements PaymentService{
    @Autowired
    CartRepository cartRepository;

    @Autowired
    PaymentRepository paymentRepository;

    ApiResponse apiResponse=new ApiResponse();


    @Override
    public HashMap<String, Boolean> addPayment(long cart_id,boolean payment_status) {
        PaymentModel paymentModel = new PaymentModel();
        CartModel cartModel =cartRepository.getOne(cart_id);
        paymentModel.setCartModel(cartModel);
        paymentModel.setPayment_status(payment_status);
        paymentRepository.save(paymentModel);
        return apiResponse.addKeyValue(true);
    }
}
