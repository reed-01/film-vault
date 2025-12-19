package org.danielreed.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class FilmSearchResponseDto {

    @JsonProperty("Search")
    private List<FilmSearchResultDto> search;

    @JsonProperty("Response")
    private String response;

    @JsonProperty("Error")
    private String error;

    public FilmSearchResponseDto() { }

    public List<FilmSearchResultDto> getSearch() {
        return search;
    }

    public void setSearch(List<FilmSearchResultDto> search) {
        this.search = search;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
