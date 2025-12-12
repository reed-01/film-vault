package org.danielreed.controller;

import org.danielreed.dao.CollectionDao;
import org.danielreed.dao.UserDao;
import org.danielreed.model.Film;
import org.danielreed.model.User;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
@RequestMapping("/collection")
public class CollectionController {

    private UserDao userDao;
    private CollectionDao collectionDao;

    public CollectionController(UserDao userDao, CollectionDao collectionDao) {
        this.userDao = userDao;
        this.collectionDao = collectionDao;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Film saveFilmToCollection(@RequestBody Film film, Principal principal) {

        String userName = principal.getName();
        User user = userDao.getUserByUsername(userName);
        int userId = user.getId();

        return collectionDao.saveFilmToCollection(film, userId);
    }

    @GetMapping
    public List<Film> getCollectionByUserId(Principal principal) {

        String userName = principal.getName();
        User user = userDao.getUserByUsername(userName);
        int userId = user.getId();

        return collectionDao.getCollectionByUserId(userId);
    }

    @DeleteMapping("/{filmId}")
    public int deleteFilmFromCollection(@PathVariable String filmId, Principal principal) {

        String userName = principal.getName();
        User user = userDao.getUserByUsername(userName);
        int userId = user.getId();

        return collectionDao.deleteFilmFromCollection(userId, filmId);
    }

    @GetMapping("type/{filmType}")
    public List<Film> getCollectionFilmsByType(@PathVariable String filmType, Principal principal) {

        String userName = principal.getName();
        User user = userDao.getUserByUsername(userName);
        int userId = user.getId();

        return collectionDao.getCollectionFilmsByType(filmType, userId);
    }

    @GetMapping("genre/{genre}")
    public List<Film> getCollectionFilmsByGenre(@PathVariable String genre, Principal principal) {

        String userName = principal.getName();
        User user = userDao.getUserByUsername(userName);
        int userId = user.getId();

        return collectionDao.getCollectionFilmsByGenre(genre, userId);
    }

    @GetMapping("rated/{rated}")
    public List<Film> getCollectionFilmsByRated(@PathVariable String rated, Principal principal) {

        String userName = principal.getName();
        User user = userDao.getUserByUsername(userName);
        int userId = user.getId();

        return collectionDao.getCollectionFilmsByRated(rated, userId);
    }

    @GetMapping("releaseYear/{releaseYear}")
    public List<Film> getCollectionFilmsByReleaseYear(@PathVariable String releaseYear, Principal principal) {

        String userName = principal.getName();
        User user = userDao.getUserByUsername(userName);
        int userId = user.getId();

        return collectionDao.getCollectionFilmsByReleaseYear(releaseYear, userId);
    }

    @GetMapping("actor/{actors}")
    public List<Film> getCollectionFilmsByActor(@PathVariable String actors, Principal principal) {

        String userName = principal.getName();
        User user = userDao.getUserByUsername(userName);
        int userId = user.getId();

        return collectionDao.getCollectionFilmsByActor(actors, userId);
    }

    @GetMapping("director/{director}")
    public List<Film> getCollectionFilmsByDirector(@PathVariable String director, Principal principal) {

        String userName = principal.getName();
        User user = userDao.getUserByUsername(userName);
        int userId = user.getId();

        return collectionDao.getCollectionFilmsByDirector(director, userId);
    }
}