package org.danielreed.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FilmSearchResultDto {

    @JsonProperty("imdbID")
    private String filmId;

    @JsonProperty("Type")
    private String filmType;

    @JsonProperty("Title")
    private String title;

    @JsonProperty("Year")
    private String releaseYear;

    @JsonProperty("Poster")
    private String poster;

    public FilmSearchResultDto() { }

    public String getFilmId() {
        return filmId;
    }

    public void setFilmId(String filmId) {
        this.filmId = filmId;
    }

    public String getFilmType() {
        return filmType;
    }

    public void setFilmType(String filmType) {
        this.filmType = filmType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }
}
