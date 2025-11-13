package org.danielreed.dao;

import org.danielreed.model.Credit;
import java.util.List;

public interface CreditDao {

    List<Credit> getCreditsForMovie(int movieId);

    List<Credit> getCreditsForTelevisionShow(int televisionShowId);
}
