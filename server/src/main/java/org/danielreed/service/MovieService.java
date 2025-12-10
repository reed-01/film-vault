package org.danielreed.service;

import org.danielreed.model.Movie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class MovieService {

    private RestClient restClient;

    @Value("${omdb.api.key}")
    private String apiKey;

    public Movie getMovieByTitle(String title) {

        String url = "http://www.omdbapi.com/?t=" + title + "&apikey=" + apiKey;

        restClient = RestClient.create(url);

        return restClient.get().uri("").retrieve().body(Movie.class);
    }
}
