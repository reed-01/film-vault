package org.danielreed.controller;

import org.danielreed.dao.MovieDao;
import org.danielreed.dao.UserDao;
import org.danielreed.model.Movie;
import org.danielreed.service.MovieService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class MovieController {

    private final MovieDao movieDao;
    private UserDao userDao;
    private MovieService movieService;

    public MovieController(MovieDao movieDao, UserDao userDao, MovieService movieService) {
        this.movieDao = movieDao;
        this.userDao = userDao;
        this.movieService = movieService;
    }

    @GetMapping("/movie")
    public Movie getMovieByTitle(@RequestParam String title) {
        return movieService.getMovieByTitle(title);
    }


}
