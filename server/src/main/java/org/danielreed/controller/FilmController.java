package org.danielreed.controller;

import org.danielreed.dao.FilmDao;
import org.danielreed.dao.UserDao;
import org.danielreed.model.Film;
import org.danielreed.service.FilmService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class FilmController {

    private final FilmDao filmDao;
    private UserDao userDao;
    private FilmService filmService;

    public FilmController(FilmDao filmDao, UserDao userDao, FilmService filmService) {
        this.filmDao = filmDao;
        this.userDao = userDao;
        this.filmService = filmService;
    }

    @GetMapping("/film")
    public Film getFilmByTitle(@RequestParam String title) {
        return filmService.getFilmByTitle(title);
    }

    @GetMapping("/film/year")
    public List<Film> getFilmsByYear(@RequestParam String releaseYear) {
        return filmDao.getFilmsByYear(releaseYear);
    }
}