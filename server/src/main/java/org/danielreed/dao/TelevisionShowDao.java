package org.danielreed.dao;

import org.danielreed.model.TelevisionShow;

import java.util.List;

public interface TelevisionShowDao {

    TelevisionShow getTelevisionShowByTitle(String title);

    List<TelevisionShow> getTelevisionShowsByReleaseDate(String releaseDate);

    List<TelevisionShow> getTelevisionShowsByYear(String releaseYear);
}
