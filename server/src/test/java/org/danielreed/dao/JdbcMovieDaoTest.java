package org.danielreed.dao;

import org.danielreed.model.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JdbcMovieDaoTest extends BaseDaoTest {

    private static final Movie MOVIE_1 = new Movie(1, "title1", "genre1", "A", "01-01-0101", "Test1 Description", "test-1.png");
    private static final Movie MOVIE_2 = new Movie(2, "title2", "genre2", "B", "02-02-0202", "Test2 Description", "test-2.png");
    private static final Movie MOVIE_3 = new Movie(3, "title3", "genre3", "C", "03-03-0303", "Test3 Description", "test-3.png");
    private static final Movie MOVIE_4 = new Movie(4, "title4", "genre4", "D", "04-04-0404", "Test4 Description", "test-4.png");


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

        Movie movie = dao.getMovieByTitle("title1");
        assertMoviesMatch(MOVIE_1, movie);

        movie = dao.getMovieByTitle("title2");
        assertMoviesMatch(MOVIE_2, movie);
    }

    @Test
    public void getMovieByTitle_with_invalid_title_returns_null_movie() {

        Movie movie = dao.getMovieByTitle("title99");
        assertNull(movie);
    }

    @Test
    public void getMoviesByGenre_only_returns_list_of_movies_with_valid_genre() {

        List<Movie> movies = dao.getMoviesByGenre("genre3");
        assertEquals(1, movies.size());
        assertMoviesMatch(MOVIE_3, movies.get(0));
    }

    @Test
    public void getMoviesByGenre_only_returns_empty_list_of_movies_with_invalid_genre() {

        List<Movie> movies = dao.getMoviesByGenre("genre99");
        assertTrue(movies.isEmpty());
    }

    @Test
    public void getMoviesByRating_only_returns_list_of_movies_with_valid_rating() {

        List<Movie> movies = dao.getMoviesByRating("D");
        assertEquals(1, movies.size());
        assertMoviesMatch(MOVIE_4, movies.get(0));
    }

    @Test
    public void getMoviesByRating_only_returns_empty_list_of_movies_with_invalid_rating() {

        List<Movie> movies = dao.getMoviesByRating("Z");
        assertTrue(movies.isEmpty());
    }

    @Test
    public void getMoviesByReleaseDate_only_returns_list_of_movies_with_valid_release_date() {

        List<Movie> movies = dao.getMoviesByReleaseDate("01-01-0101");
        assertEquals(1, movies.size());
        assertMoviesMatch(MOVIE_1, movies.get(0));
    }

    @Test
    public void getMoviesByReleaseDate_only_returns_empty_list_of_movies_with_invalid_release_date() {

        List<Movie> movies = dao.getMoviesByReleaseDate("88-88-8888");
        assertTrue(movies.isEmpty());
    }

    private void assertMoviesMatch(Movie expected, Movie actual) {

        assertEquals(expected.getMovieId(), actual.getMovieId());
        assertEquals(expected.getTitle(), actual.getTitle());
        assertEquals(expected.getGenre(), actual.getGenre());
        assertEquals(expected.getRating(), actual.getRating());
        assertEquals(expected.getReleaseDate(), actual.getReleaseDate());
        assertEquals(expected.getDescription(), actual.getDescription());
        assertEquals(expected.getCoverImage(), actual.getCoverImage());
    }
}
