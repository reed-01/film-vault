package org.danielreed.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class TelevisionShow {

    @JsonProperty("imdbID")
    private String televisionShowId;

    @JsonProperty("Type")
    private String type;

    @JsonProperty("Title")
    private String title;

    @JsonProperty("Year")
    private String releaseYear;

    @JsonProperty("Rated")
    private String rated;

    @JsonProperty("Released")
    private String releaseDate;

    @JsonProperty("Runtime")
    private String runtime;

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

    public TelevisionShow() { }

    public TelevisionShow(String televisionShowId, String type, String title, String releaseYear, String rated, String releaseDate, String runtime, String plot, String language, String country, String awards, String poster) {
        this.televisionShowId = televisionShowId;
        this.type = type;
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

    public String getTelevisionShowId() {
        return televisionShowId;
    }

    public void setTelevisionShowId(String televisionShowId) {
        this.televisionShowId = televisionShowId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        return "TelevisionShow{" +
                "televisionShowId='" + televisionShowId + '\'' +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", releaseYear='" + releaseYear + '\'' +
                ", rated='" + rated + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", runtime='" + runtime + '\'' +
                ", plot='" + plot + '\'' +
                ", language='" + language + '\'' +
                ", country='" + country + '\'' +
                ", awards='" + awards + '\'' +
                ", poster='" + poster + '\'' +
                '}';
    }
}
