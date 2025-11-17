package org.danielreed.dao;

import org.danielreed.model.TelevisionShow;

import java.time.LocalDate;
import java.util.List;

public interface TelevisionShowDao {

    List<TelevisionShow> getAllTelevisionShows();

    TelevisionShow getTelevisionShowByTitle(String title);

    List<TelevisionShow> getTelevisionShowsByReleaseDate(LocalDate releaseDate);
}
