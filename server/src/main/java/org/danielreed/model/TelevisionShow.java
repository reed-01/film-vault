package org.danielreed.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class TelevisionShow {

    @JsonProperty("id")
    private int televisionShowId;
    @JsonProperty("name")
    private String title;
    @JsonProperty("release_date")
    private LocalDate releaseDate;
    @JsonProperty("overview")
    private String overview;
    @JsonProperty("poster_path")
    private String posterPath;

    public TelevisionShow() { }

    public TelevisionShow(int televisionShowId, String title, LocalDate releaseDate, String overview, String posterPath) {
        this.televisionShowId = televisionShowId;
        this.title = title;
        this.releaseDate = releaseDate;
        this.overview = overview;
        this.posterPath = posterPath;
    }

    public int getTelevisionShowId() {
        return televisionShowId;
    }

    public void setTelevisionShowId(int televisionShowId) {
        this.televisionShowId = televisionShowId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    @Override
    public String toString() {
        return "TelevisionShow{" +
                "televisionShowId=" + televisionShowId +
                ", title='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                ", overview='" + overview + '\'' +
                ", posterPath='" + posterPath + '\'' +
                '}';
    }
}
