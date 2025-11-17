package org.danielreed.model;

import java.time.LocalDate;

public class TelevisionShow {

    private int televisionShowId;
    private String title;
    private LocalDate releaseDate;
    private String overview;
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
}
