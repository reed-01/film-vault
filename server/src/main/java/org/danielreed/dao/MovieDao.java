package org.danielreed.dao;

import org.danielreed.model.Movie;

import java.time.LocalDate;
import java.util.List;

public interface MovieDao {

    Movie getMovieByTitle(String title);

    List<Movie> getMoviesByReleaseDate(LocalDate releaseDate);

    List<Movie> getMoviesByYear(String releaseYear);
}
