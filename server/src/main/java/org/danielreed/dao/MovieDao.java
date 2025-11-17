package org.danielreed.dao;

import org.danielreed.model.Movie;

import java.time.LocalDate;
import java.util.List;

public interface MovieDao {

    List<Movie> getAllMovies();

    Movie getMovieByTitle(String title);

    List<Movie> getMoviesByReleaseDate(LocalDate releaseDate);
}
