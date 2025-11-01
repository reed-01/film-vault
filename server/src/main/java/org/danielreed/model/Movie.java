package org.danielreed.model;

public class Movie {

    private int movieId;
    private String title;
    private String genre;
    private String rating;
    private String releaseDate;
    private String description;
    private String coverImage;

    public Movie() { }

    public Movie(int movieId, String title, String genre, String releaseDate, String rating, String description, String coverImage) {
        this.movieId = movieId;
        this.title = title;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.description = description;
        this.coverImage = coverImage;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }
}
