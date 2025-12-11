package org.danielreed.service;
import org.danielreed.model.Film;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class FilmService {

    private RestClient restClient;

    @Value("${omdb.api.key}")
    private String apiKey;

    public Film getFilmByTitle(String title) {

        // encode title to account for special char in film title spacing
        String encodedTitle = URLEncoder.encode(title, StandardCharsets.UTF_8);

        String url = "http://www.omdbapi.com/?t=" + encodedTitle + "&apikey=" + apiKey;

        restClient = RestClient.create(url);

        return restClient.get().uri("").retrieve().body(Film.class);
    }
}