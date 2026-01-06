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
    public Film postFilmToCollection(@RequestBody Film film, Principal principal) {

        String userName = principal.getName();
        User user = userDao.getUserByUsername(userName);
        int userId = user.getId();

        return collectionDao.postFilmToCollection(film, userId);
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
}