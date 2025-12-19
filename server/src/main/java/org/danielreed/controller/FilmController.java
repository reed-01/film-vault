package org.danielreed.controller;

import org.danielreed.model.Film;
import org.danielreed.model.FilmSearchResultDto;
import org.danielreed.service.FilmService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<FilmSearchResultDto> searchFilmsByTitle(@RequestParam String title) {
        return filmService.searchFilmsByTitle(title);
    }
}