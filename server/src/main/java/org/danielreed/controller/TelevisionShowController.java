package org.danielreed.controller;

import org.danielreed.dao.TelevisionShowDao;
import org.danielreed.model.TelevisionShow;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/television_shows")
@PreAuthorize("isAuthenticated()")
public class TelevisionShowController {

    private final TelevisionShowDao televisionShowDao;

    public TelevisionShowController(TelevisionShowDao televisionShowDao) {
        this.televisionShowDao = televisionShowDao;
    }

    @PreAuthorize("permitAll")
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<TelevisionShow> getAllTelevisionShows() {
        return televisionShowDao.getAllTelevisionShows();
    }

    @PreAuthorize("permitAll")
    @RequestMapping(path = "/{title}", method = RequestMethod.GET)
    public TelevisionShow getTelevisionShowByTitle(@PathVariable String title) {

        TelevisionShow televisionShow = televisionShowDao.getTelevisionShowByTitle(title);
        if (televisionShow == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found");
        }

        return televisionShow;
    }

    @PreAuthorize("permitAll")
    @RequestMapping(path = "/{release_date}", method = RequestMethod.GET)
    public List<TelevisionShow> getTelevisionShowsByReleaseDate(@PathVariable LocalDate releaseDate) {
        return televisionShowDao.getTelevisionShowsByReleaseDate(releaseDate);
    }
}
