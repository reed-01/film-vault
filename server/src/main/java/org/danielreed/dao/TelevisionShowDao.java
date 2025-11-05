package org.danielreed.dao;

import org.danielreed.model.TelevisionShow;
import java.util.List;

public interface TelevisionShowDao {

    List<TelevisionShow> getAllTelevisionShows();

    TelevisionShow getTelevisionShowsByTitle(String title);

    List<TelevisionShow> getTelevisionShowsByReleaseDate(String releaseDate);
}
