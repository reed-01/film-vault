package org.danielreed.service;


import org.danielreed.model.TelevisionShow;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class TelevisionShowService {

    private RestClient restClient;

    @Value("${omdb.api.key}")
    private String apiKey;

    public TelevisionShow getTelevisionShowByTitle(String title) {

        String url = "http://www.omdbapi.com/?t=" + title + "&apikey=" + apiKey;

        restClient = RestClient.create(url);

        return restClient.get().uri("").retrieve().body(TelevisionShow.class);
    }
}
