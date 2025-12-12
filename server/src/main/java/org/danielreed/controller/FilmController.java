package org.danielreed.controller;

import org.danielreed.model.Film;
import org.danielreed.service.FilmService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class FilmController {

    private FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/film")
    public Film getFilmByTitle(@RequestParam String title) {
        return filmService.getFilmByTitle(title);
    }
}