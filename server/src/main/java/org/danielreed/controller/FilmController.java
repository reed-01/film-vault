package org.danielreed.controller;

import org.danielreed.model.Film;
import org.danielreed.service.FilmService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/film")
public class FilmController {

    private FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/{filmId}")
    public Film getFilmById(@PathVariable String filmId) {
        return filmService.getFilmById(filmId);
    }

    @GetMapping("/search")
    public Film getFilmByTitle(@RequestParam String title) {
        return filmService.getFilmByTitle(title);
    }
}