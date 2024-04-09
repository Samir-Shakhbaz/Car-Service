package com.example.carservice.controllers;

import com.example.carservice.client.WeatherAPIClient;
import com.example.carservice.client.WeatherAPIResponse;
import com.example.carservice.client.jokes.JokesAPIClient;
import com.example.carservice.client.jokes.JokesAPIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    WeatherAPIClient weatherAPIClient;

    @Autowired
    private JokesAPIClient jokesAPIClient;

    @GetMapping("/home")
    public String greeting(Model model) {

        try {
            WeatherAPIResponse weatherAPIResponse = weatherAPIClient.getWeather("Rostov");
            model.addAttribute("weather", weatherAPIResponse);
        } catch(Exception e){
            model.addAttribute("weather", "no data");
        }

        try {
            JokesAPIResponse jokesAPIResponse = jokesAPIClient.getRandomJoke();
            model.addAttribute("joke", jokesAPIResponse.getJoke());
        } catch (Exception e) {
            model.addAttribute("joke", "No joke available at the moment");
        }

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