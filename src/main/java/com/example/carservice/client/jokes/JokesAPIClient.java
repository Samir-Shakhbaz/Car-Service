package com.example.carservice.client.jokes;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class JokesAPIClient {
    @Autowired
    private RestTemplate restTemplate;

    public JokesAPIResponse getRandomJoke() {
        ResponseEntity<JokesAPIResponse> response = restTemplate.getForEntity("https://api.chucknorris.io/jokes/random", JokesAPIResponse.class);
        System.out.println(response);
        System.out.println(response.getBody());

        return response.getBody();
    }
}

//@Data
//public class JokesAPIClient {
//    private HttpClient client;
//
//    public JokesAPIClient() {
//        client = HttpClient.newHttpClient();
//    }
//
//    public String getRandomJoke() throws IOException, InterruptedException {
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("https://api.chucknorris.io/jokes/random"))
//                .GET()
//                .build();
//
//        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//
//        try (JsonReader jsonReader = Json.createReader(new StringReader(response.body()))) {
//            JsonObject jsonObject = jsonReader.readObject();
//            return jsonObject.getString("value");
//        }
//    }
//}
