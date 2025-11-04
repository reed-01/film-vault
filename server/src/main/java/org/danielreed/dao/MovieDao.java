package org.danielreed.dao;

import org.danielreed.model.Movie;
import java.util.List;

public interface MovieDao {

    List<Movie> getAllMovies();

    Movie getMovieByTitle(String title);

    List<Movie> getMoviesByReleaseDate(String releaseDate);
}
