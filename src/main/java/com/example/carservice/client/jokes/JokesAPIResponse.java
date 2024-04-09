package com.example.carservice.client.jokes;

import lombok.Data;

import java.util.List;

@Data
public class JokesAPIResponse {
//    private String icon_url;
//    private String id;
//    private String url;
    private String value;

    List<Jokes> jokesList;

    public String getJoke() {
        return value;
    }
}
