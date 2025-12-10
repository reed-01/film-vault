//package org.danielreed.controller;
//
//
//import org.danielreed.dao.CreditDao;
//import org.danielreed.model.Credit;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@CrossOrigin
//@RequestMapping("/credits")
//@PreAuthorize("isAuthenticated()")
//public class CreditController {
//
//    private final CreditDao creditDao;
//
//    public CreditController(CreditDao creditDao) {
//        this.creditDao = creditDao;
//    }
//
//    @PreAuthorize("permitAll")
//    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
//    public List<Credit> getCreditsForMovie(@PathVariable int movieId) {
//        return creditDao.getCreditsForMovie(movieId);
//    }
//
//    @PreAuthorize("permitAll")
//    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
//    public List<Credit> getCreditsForTelevisionShow(@PathVariable int televisionShowId) {
//        return creditDao.getCreditsForTelevisionShow(televisionShowId);
//    }
//}
