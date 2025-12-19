package org.danielreed.service;
import org.danielreed.model.Film;

import org.danielreed.model.FilmSearchResponseDto;
import org.danielreed.model.FilmSearchResultDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class FilmService {

    @Value("${omdb.api.key}")
    private String apiKey;

    public Film getFilmById(String filmId) {

        String url = "http://www.omdbapi.com/?i=" + filmId + "&apikey=" + apiKey;

        RestClient restClient = RestClient.create(url);

        return restClient.get().uri("").retrieve().body(Film.class);
    }

//    Multiple-result search for frontend view
    public List<FilmSearchResultDto> searchFilmsByTitle(String title) {

        // encode title to account for special char in film title spacing
        String encodedTitle = URLEncoder.encode(title, StandardCharsets.UTF_8);

        String url = "http://www.omdbapi.com/?s=" + encodedTitle + "&apikey=" + apiKey;

        RestClient restClient = RestClient.create(url);
        FilmSearchResponseDto responseDto = restClient.get().uri("").retrieve().body(FilmSearchResponseDto.class);

        if (responseDto == null || responseDto.getSearch() == null) {
            return Collections.emptyList();
        }

        // Filter to only show movies and series
        List<FilmSearchResultDto> results = new ArrayList<>();

        for (FilmSearchResultDto film : responseDto.getSearch()) {

            String type = film.getFilmType();

            if ("movie".equalsIgnoreCase(type) || "series".equalsIgnoreCase(type)) {
                results.add(film);
            }
        }

        return results;
    }
}