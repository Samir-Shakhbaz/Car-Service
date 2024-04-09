package com.example.carservice.controllers;

import com.stripe.Stripe;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import java.util.HashMap;
import java.util.Map;

@Controller
public class StripeController {

    @PostMapping("/create-payment-intent")
    @ResponseBody

    public Map<String, Object> createPaymentIntent(@RequestBody Map<String, Object> requestData) {
        try {
            // setting up Stripe API key
            Stripe.apiKey = "liveKey";

            // creating PaymentIntent
            PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                    .setCurrency("usd")
                    .setAmount((long) requestData.get("amount"))
                    .build();
            PaymentIntent intent = PaymentIntent.create(params);

            // return client secret to frontend
            Map<String, Object> responseData = new HashMap<>();
            responseData.put("clientSecret", intent.getClientSecret());
            return responseData;
        } catch (StripeException e) {
            e.printStackTrace();
            // handling Stripe exception
            return null;
        }
    }

    @GetMapping("/stripe-payment")
    public String showPaymentForm() {
        return "stripe-payment";
    }

}
