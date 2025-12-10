//package org.danielreed.controller;
//
//
//import org.danielreed.dao.GenreDao;
//import org.danielreed.model.Genre;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@CrossOrigin
//@RequestMapping("/genres")
//@PreAuthorize("isAuthenticated()")
//public class GenreController {
//
//    private final GenreDao genreDao;
//
//    public GenreController(GenreDao genreDao) {
//        this.genreDao = genreDao;
//    }
//
//    @PreAuthorize("permitAll")
//    @RequestMapping(path = "/{genres}", method = RequestMethod.GET)
//    public List<Genre> getGenresByMovie(@PathVariable String name) {
//        return genreDao.getGenresByMovie(name);
//    }
//
//    @PreAuthorize("permitAll")
//    @RequestMapping(path = "/{genres}", method = RequestMethod.GET)
//    public List<Genre> getGenresByTelevision(@PathVariable String name) {
//        return genreDao.getGenresByTelevisionShow(name);
//    }
//}
