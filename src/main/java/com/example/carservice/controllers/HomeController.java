package com.example.carservice.controllers;

import com.example.carservice.client.WeatherAPIClient;
import com.example.carservice.client.WeatherAPIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    WeatherAPIClient weatherAPIClient;



    @GetMapping("/home")
    public String greeting(Model model) {

//        WeatherAPIResponse weatherAPIResponse = weatherAPIClient.getWeather("Moscow");
//        model.addAttribute("weather", weatherAPIResponse);

        return "home";
    }

    @GetMapping("/hello") //THIS END POINT IS USED FOR TESTING
    public String greeting2() {
        return "Hello and welcome!";
    }

    @GetMapping("/about")
    public String about(Model model) {

        return "about";
    }
}