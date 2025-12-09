package org.danielreed.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class Movie {

    @JsonProperty("imdbID")
    private String movieId;

    @JsonProperty("Title")
    private String title;

    @JsonProperty("Year")
    private int releaseYear;

    @JsonProperty("Rated")
    private String rated;

    @JsonProperty("Released")
    private LocalDate releaseDate;

    @JsonProperty("Runtime")
    private int runtime;

    @JsonProperty("Plot")
    private String plot;

    @JsonProperty("Language")
    private String language;

    @JsonProperty("Country")
    private String country;

    @JsonProperty("Awards")
    private String awards;

    @JsonProperty("Poster")
    private String poster;

    public Movie() { }

    public Movie(String movieId, String title, int releaseYear, String rated, LocalDate releaseDate, int runtime, String plot, String language, String country, String awards, String poster) {
        this.movieId = movieId;
        this.title = title;
        this.releaseYear = releaseYear;
        this.rated = rated;
        this.releaseDate = releaseDate;
        this.runtime = runtime;
        this.plot = plot;
        this.language = language;
        this.country = country;
        this.awards = awards;
        this.poster = poster;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId='" + movieId + '\'' +
                ", title='" + title + '\'' +
                ", releaseYear=" + releaseYear +
                ", rated='" + rated + '\'' +
                ", releaseDate=" + releaseDate +
                ", runtime=" + runtime +
                ", plot='" + plot + '\'' +
                ", language='" + language + '\'' +
                ", country='" + country + '\'' +
                ", awards='" + awards + '\'' +
                ", poster='" + poster + '\'' +
                '}';
    }
}
