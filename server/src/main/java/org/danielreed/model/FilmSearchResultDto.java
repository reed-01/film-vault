package org.danielreed.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public class FilmSearchResultDto {

    @JsonAlias("imdbID")
    private String filmId;

    @JsonAlias("Type")
    private String filmType;

    @JsonAlias("Title")
    private String title;

    @JsonAlias("Year")
    private String releaseYear;

    @JsonAlias("Poster")
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
