package org.danielreed.dao;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.danielreed.model.Film;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JdbcFilmDaoTest extends BaseDaoTest {

    private static final Film FILM_1 = new Film("1", "type1", "title1", "0101", "A", "01-01-0101", "111", "genre1", "director1", "actor1", "plot1", "language1", "country1", "awards1", "poster1.jpg", "11.11");
    private static final Film FILM_2 = new Film("2", "type2", "title2", "0202", "B", "02-02-0202", "222", "genre2", "director2", "actor2", "plot2", "language2", "country2", "awards2", "poster2.jpg", "22.22");

    private JdbcFilmDao dao;

    @BeforeEach
    public void setup() {
        dao = new JdbcFilmDao(dataSource);
    }

    @Test
    public void getFilmByTitle_with_valid_title_returns_correct_film() {

        Film film = dao.getFilmByTitle("title1");
        assertFilmsMatch(FILM_1, film);

        film = dao.getFilmByTitle("title2");
        assertFilmsMatch(FILM_2, film);
    }

    @Test
    public void getFilmByTitle_with_invalid_title_returns_null() {

        Film film = dao.getFilmByTitle("title99");
        assertNull(film);
    }

    private void assertFilmsMatch(Film expected, Film actual) {

        assertEquals(expected.getFilmId(), actual.getFilmId());
        assertEquals(expected.getFilmType(), actual.getFilmType());
        assertEquals(expected.getTitle(), actual.getTitle());
        assertEquals(expected.getReleaseYear(), actual.getReleaseYear());
        assertEquals(expected.getRated(), actual.getRated());
        assertEquals(expected.getReleaseDate(), actual.getReleaseDate());
        assertEquals(expected.getRuntime(), actual.getRuntime());
        assertEquals(expected.getGenre(), actual.getGenre());
        assertEquals(expected.getDirector(), actual.getDirector());
        assertEquals(expected.getActors(), actual.getActors());
        assertEquals(expected.getPlot(), actual.getPlot());
        assertEquals(expected.getLanguage(), actual.getLanguage());
        assertEquals(expected.getCountry(), actual.getCountry());
        assertEquals(expected.getAwards(), actual.getAwards());
        assertEquals(expected.getPoster(), actual.getPoster());
        assertEquals(expected.getImdbRating(), actual.getImdbRating());
    }
}
