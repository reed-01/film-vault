package org.danielreed.controller;

import org.danielreed.dao.MovieDao;
import org.danielreed.model.Movie;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/movies")
@PreAuthorize("isAuthenticated()")
public class MovieController {

    private final MovieDao movieDao;

    public MovieController(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @PreAuthorize("permitAll")
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Movie> getAllMovies() {
        return movieDao.getAllMovies();
    }

    @PreAuthorize("permitAll")
    @RequestMapping(path = "/{title}", method = RequestMethod.GET)
    public Movie getMovieByTitle(@PathVariable String title) {

        Movie movie = movieDao.getMovieByTitle(title);
        if (movie == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found");
        }

        return movie;
    }

    @PreAuthorize("permitAll")
    @RequestMapping(path = "/{genre}", method = RequestMethod.GET)
    public List<Movie> getMoviesByGenre(@PathVariable String genre) {
        return movieDao.getMoviesByGenre(genre);
    }

    @PreAuthorize("permitAll")
    @RequestMapping(path = "/{rating}", method = RequestMethod.GET)
    public List<Movie> getMoviesByRating(@PathVariable String rating) {
        return movieDao.getMoviesByGenre(rating);
    }

    @PreAuthorize("permitAll")
    @RequestMapping(path = "/{release_date}", method = RequestMethod.GET)
    public List<Movie> getMoviesByReleaseDate(@PathVariable String releaseDate) {
        return movieDao.getMoviesByGenre(releaseDate);
    }
}
