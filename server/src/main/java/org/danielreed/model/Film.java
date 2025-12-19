package org.danielreed.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public class Film {

    @JsonAlias("imdbID")
    private String filmId;

    @JsonAlias("Type")
    private String filmType;

    @JsonAlias("Title")
    private String title;

    @JsonAlias("Year")
    private String releaseYear;

    @JsonAlias("Rated")
    private String rated;

    @JsonAlias("Released")
    private String releaseDate;

    @JsonAlias("Runtime")
    private String runtime;

    @JsonAlias("Genre")
    private String genre;

    @JsonAlias("Director")
    private String director;

    @JsonAlias("Actors")
    private String actors;

    @JsonAlias("Plot")
    private String plot;

    @JsonAlias("Language")
    private String language;

    @JsonAlias("Country")
    private String country;

    @JsonAlias("Awards")
    private String awards;

    @JsonAlias("Poster")
    private String poster;

    @JsonAlias("imdbRating")
    private String imdbRating;

    public Film() { }

    public Film(String filmId, String filmType, String title, String releaseYear, String rated, String releaseDate, String runtime, String genre, String director, String actors, String plot, String language, String country, String awards, String poster, String imdbRating) {
        this.filmId = filmId;
        this.filmType = filmType;
        this.title = title;
        this.releaseYear = releaseYear;
        this.rated = rated;
        this.releaseDate = releaseDate;
        this.runtime = runtime;
        this.genre = genre;
        this.director = director;
        this.actors = actors;
        this.plot = plot;
        this.language = language;
        this.country = country;
        this.awards = awards;
        this.poster = poster;
        this.imdbRating = imdbRating;
    }

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

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
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

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    @Override
    public String toString() {
        return "Film{" +
                "filmId='" + filmId + '\'' +
                ", filmType='" + filmType + '\'' +
                ", title='" + title + '\'' +
                ", releaseYear='" + releaseYear + '\'' +
                ", rated='" + rated + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", runtime='" + runtime + '\'' +
                ", genre='" + genre + '\'' +
                ", director='" + director + '\'' +
                ", actors='" + actors + '\'' +
                ", plot='" + plot + '\'' +
                ", language='" + language + '\'' +
                ", country='" + country + '\'' +
                ", awards='" + awards + '\'' +
                ", poster='" + poster + '\'' +
                ", imdbRating='" + imdbRating + '\'' +
                '}';
    }
}