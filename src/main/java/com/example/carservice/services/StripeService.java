package com.example.carservice.services;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Subscription;
import com.stripe.param.SubscriptionCreateParams;

public class StripeService {

    // Set your Stripe API key
    private static final String API_KEY = "sk_test_YourSecretKey";

    public void createSubscription(String customerId, String planId) {
        Stripe.apiKey = API_KEY;

        try {
            SubscriptionCreateParams params = SubscriptionCreateParams.builder()
                    .setCustomer(customerId)
                    .addItem(SubscriptionCreateParams.Item.builder()
                            .setPlan(planId)
                            .build())
                    .build();

            Subscription subscription = Subscription.create(params);

            System.out.println("Subscription created successfully: " + subscription.getId());
        } catch (StripeException e) {

            System.err.println("Stripe Exception: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {

            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
