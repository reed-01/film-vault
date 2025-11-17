package org.danielreed.dao;

import org.danielreed.model.Genre;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JdbcGenreDaoTest extends BaseDaoTest {

    private static final Genre GENRE_1 = new Genre(1, "genre1");
    private static final Genre GENRE_2 = new Genre(2, "genre2");

    private JdbcGenreDao dao;

    @BeforeEach
    public void setup() {
        dao = new JdbcGenreDao(dataSource);
    }

    @Test
    public void getGenresByMovie_only_returns_list_of_genres_for_valid_movie() {

        List<Genre> genres = dao.getGenresByMovie("movie1");

        assertEquals(2, genres.size());
        assertGenresMatch(GENRE_1, genres.get(0));
        assertGenresMatch(GENRE_2, genres.get(1));
    }

    @Test
    public void getGenreByMovie_only_returns_empty_list_of_genres_for_invalid_movie() {

        List<Genre> genres = dao.getGenresByMovie("movie99");
        assertTrue(genres.isEmpty());
    }

    @Test
    public void getGenresByTelevisionShow_only_returns_list_of_genres_for_valid_television_show() {

        List<Genre> genres = dao.getGenresByTelevisionShow("show2");

        assertEquals(2, genres.size());
        assertGenresMatch(GENRE_1, genres.get(0));
        assertGenresMatch(GENRE_2, genres.get(1));
    }

    @Test
    public void getGenresByTelevisionShow_only_returns_empty_list_of_genres_for_invalid_television_show() {

        List<Genre> genres = dao.getGenresByTelevisionShow("show99");
        assertTrue(genres.isEmpty());
    }

    private void assertGenresMatch(Genre expected, Genre actual) {

        assertEquals(expected.getGenreId(), actual.getGenreId());
        assertEquals(expected.getName(), actual.getName());
    }
}
