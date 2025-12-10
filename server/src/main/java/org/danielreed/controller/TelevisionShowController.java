package org.danielreed.controller;

import org.danielreed.dao.TelevisionShowDao;
import org.danielreed.dao.UserDao;
import org.danielreed.model.TelevisionShow;
import org.danielreed.service.TelevisionShowService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class TelevisionShowController {

    private final TelevisionShowDao televisionShowDao;
    private UserDao userDao;
    private TelevisionShowService televisionShowService;

    public TelevisionShowController(TelevisionShowDao televisionShowDao, UserDao userDao, TelevisionShowService televisionShowService) {
        this.televisionShowDao = televisionShowDao;
        this.userDao = userDao;
        this.televisionShowService = televisionShowService;
    }

    @GetMapping("/tv")
    public TelevisionShow getTelevisionShowByTitle(@RequestParam String title) {
        return televisionShowService.getTelevisionShowByTitle(title);
    }
}
