package com.example.carservice.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class StripeConfig {

    private String testSecretKey;
    private String liveSecretKey;

    public StripeConfig() {
        Properties props = new Properties();
        try (InputStream input = new FileInputStream("config.properties")) {
            props.load(input);
            testSecretKey = props.getProperty("stripe.test.secret_key");
            liveSecretKey = props.getProperty("stripe.live.secret_key");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getTestSecretKey() {
        return testSecretKey;
    }

    public String getLiveSecretKey() {
        return liveSecretKey;
    }
}
