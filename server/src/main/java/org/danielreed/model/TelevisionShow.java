package org.danielreed.model;

public class TelevisionShow {

    private int televisionShowId;
    private String title;
    private String releaseDate;
    private String overview;
    private String poster;

    public TelevisionShow() { }

    public TelevisionShow(int televisionShowId, String title, String releaseDate, String overview, String poster) {
        this.televisionShowId = televisionShowId;
        this.title = title;
        this.releaseDate = releaseDate;
        this.overview = overview;
        this.poster = poster;
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

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }
}
