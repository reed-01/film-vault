package org.danielreed.dao;

import org.danielreed.model.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JdbcMovieDaoTest extends BaseDaoTest {

    private static final Movie MOVIE_1 = new Movie(1, "movie1", LocalDate.parse("0001-01-01"), "movie1 description", "movie-1.png");
    private static final Movie MOVIE_2 = new Movie(2, "movie2", LocalDate.parse("0002-02-02"), "movie2 description", "movie-2.png");
    private static final Movie MOVIE_3 = new Movie(3, "movie3", LocalDate.parse("0003-03-03"), "movie3 description", "movie-3.png");
    private static final Movie MOVIE_4 = new Movie(4, "movie4", LocalDate.parse("0004-04-04"), "movie4 description", "movie-4.png");

    private JdbcMovieDao dao;

    @BeforeEach
    public void setup() {
        dao = new JdbcMovieDao(dataSource);
    }

    @Test
    public void getAllMovies_returns_correct_movies() {

        List<Movie> movies = dao.getAllMovies();

        assertEquals(4, movies.size());

        assertMoviesMatch(MOVIE_1, movies.get(0));
        assertMoviesMatch(MOVIE_2, movies.get(1));
        assertMoviesMatch(MOVIE_3, movies.get(2));
        assertMoviesMatch(MOVIE_4, movies.get(3));
    }

    @Test
    public void getMovieByTitle_with_valid_title_returns_correct_movie() {

        Movie movie = dao.getMovieByTitle("movie1");
        assertMoviesMatch(MOVIE_1, movie);

        movie = dao.getMovieByTitle("movie2");
        assertMoviesMatch(MOVIE_2, movie);
    }

    @Test
    public void getMovieByTitle_with_invalid_title_returns_null_movie() {

        Movie movie = dao.getMovieByTitle("movie99");
        assertNull(movie);
    }

    @Test
    public void getMoviesByReleaseDate_only_returns_list_of_movies_with_valid_release_date() {

        List<Movie> movies = dao.getMoviesByReleaseDate(LocalDate.parse("0001-01-01"));
        assertEquals(1, movies.size());
        assertMoviesMatch(MOVIE_1, movies.get(0));
    }

    @Test
    public void getMoviesByReleaseDate_only_returns_empty_list_of_movies_with_invalid_release_date() {

        List<Movie> movies = dao.getMoviesByReleaseDate(LocalDate.parse("1999-01-01"));
        assertTrue(movies.isEmpty());
    }

    private void assertMoviesMatch(Movie expected, Movie actual) {

        assertEquals(expected.getMovieId(), actual.getMovieId());
        assertEquals(expected.getTitle(), actual.getTitle());
        assertEquals(expected.getReleaseDate(), actual.getReleaseDate());
        assertEquals(expected.getOverview(), actual.getOverview());
        assertEquals(expected.getPosterPath(), actual.getPosterPath());
    }
}
