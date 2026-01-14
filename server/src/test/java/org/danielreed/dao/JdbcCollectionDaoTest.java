package org.danielreed.dao;

import org.danielreed.model.Film;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JdbcCollectionDaoTest extends BaseDaoTest {

    private static final int USER_1_ID = 1;
    private static final int USER_3_ID = 3;

    private static final Film FILM_1 = new Film("1", "type1", "title1", "0101", "A", "01-01-0101", "111", "genre1", "director1", "actor1", "plot1", "language1", "country1", "awards1", "poster1.jpg", "11.11");
    private static final Film NEW_FILM = new Film("tt9999999", "movie", "newTitle", "2025", "PG-13", "01-01-2025", "123", "Action", "New Director", "Actor A", "New plot", "English", "USA", "None", "poster-new.jpg", "7.1");

    private JdbcCollectionDao dao;

    @BeforeEach
    public void setup() {
        dao = new JdbcCollectionDao(dataSource);
    }

    @Test
    public void postFilmToCollection_adds_new_film() {

        Film postedFilm = dao.postFilmToCollection(NEW_FILM, USER_3_ID);
        assertNotNull(postedFilm);

        List<Film> collection = dao.getCollectionByUserId(USER_3_ID);
        assertEquals(1, collection.size());
        assertFilmsMatch(NEW_FILM, collection.get(0));
    }

    @Test
    public void getCollectionByUserId_returns_correct_films() {

        List<Film> collection = dao.getCollectionByUserId(USER_1_ID);
        assertEquals(1, collection.size());
        assertFilmsMatch(FILM_1, collection.get(0));
    }

    @Test
    public void deleteFilmFromCollection_deletes_film() {

        int rowsAffected = dao.deleteFilmFromCollection(USER_1_ID, "1");
        assertEquals(1, rowsAffected);

        List<Film> retrievedCollection = dao.getCollectionByUserId(USER_1_ID);
        assertNotNull(retrievedCollection);
        assertTrue(retrievedCollection.isEmpty());
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
