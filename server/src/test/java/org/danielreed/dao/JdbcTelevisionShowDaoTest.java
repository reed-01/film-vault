//package org.danielreed.dao;
//
//import org.danielreed.model.TelevisionShow;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.time.LocalDate;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class JdbcTelevisionShowDaoTest extends BaseDaoTest {
//
//    private static final TelevisionShow TELEVISION_SHOW_1 = new TelevisionShow(1, "show1", LocalDate.parse("0001-01-01"), "show1 description", "show-1.png");
//    private static final TelevisionShow TELEVISION_SHOW_2 = new TelevisionShow(2, "show2", LocalDate.parse("0002-02-02"), "show2 description", "show-2.png");
//    private static final TelevisionShow TELEVISION_SHOW_3 = new TelevisionShow(3, "show3", LocalDate.parse("0003-03-03"), "show3 description", "show-3.png");
//    private static final TelevisionShow TELEVISION_SHOW_4 = new TelevisionShow(4, "show4", LocalDate.parse("0004-04-04"), "show4 description", "show-4.png");
//
//    private JdbcTelevisionShowDao dao;
//
//    @BeforeEach
//    public void setup() {
//        dao = new JdbcTelevisionShowDao(dataSource);
//    }
//
//    @Test
//    public void getAllTelevisionShows_returns_correct_television_shows() {
//
//        List<TelevisionShow> televisionShows = dao.getAllTelevisionShows();
//
//        assertEquals(4, televisionShows.size());
//
//        assertTelevisionShowsMatch(TELEVISION_SHOW_1, televisionShows.get(0));
//        assertTelevisionShowsMatch(TELEVISION_SHOW_2, televisionShows.get(1));
//        assertTelevisionShowsMatch(TELEVISION_SHOW_3, televisionShows.get(2));
//        assertTelevisionShowsMatch(TELEVISION_SHOW_4, televisionShows.get(3));
//    }
//
//    @Test
//    public void getTelevisionShowByTitle_with_valid_title_returns_correct_television_show() {
//
//        TelevisionShow televisionShow = dao.getTelevisionShowByTitle("show1");
//        assertTelevisionShowsMatch(TELEVISION_SHOW_1, televisionShow);
//
//        televisionShow = dao.getTelevisionShowByTitle("show2");
//        assertTelevisionShowsMatch(TELEVISION_SHOW_2, televisionShow);
//    }
//
//    @Test
//    public void getTelevisionShowsByTitle_with_invalid_title_returns_null_television_show() {
//
//        TelevisionShow televisionShow = dao.getTelevisionShowByTitle("show99");
//        assertNull(televisionShow);
//    }
//
//    @Test
//    public void getTelevisionShowsByReleaseDate_only_returns_list_of_television_shows_with_valid_release_date() {
//
//        List<TelevisionShow> televisionShows = dao.getTelevisionShowsByReleaseDate(LocalDate.parse("0001-01-01"));
//        assertEquals(1, televisionShows.size());
//        assertTelevisionShowsMatch(TELEVISION_SHOW_1, televisionShows.get(0));
//    }
//
//    @Test
//    public void getTelevisionShowsByReleaseDate_only_returns_empty_list_of_television_shows_with_invalid_release_date() {
//
//        List<TelevisionShow> televisionShows = dao.getTelevisionShowsByReleaseDate(LocalDate.parse("1999-01-01"));
//        assertTrue(televisionShows.isEmpty());
//    }
//
//    private void assertTelevisionShowsMatch(TelevisionShow expected, TelevisionShow actual) {
//
//        assertEquals(expected.getTelevisionShowId(), actual.getTelevisionShowId());
//        assertEquals(expected.getTitle(), actual.getTitle());
//        assertEquals(expected.getReleaseDate(), actual.getReleaseDate());
//        assertEquals(expected.getOverview(), actual.getOverview());
//        assertEquals(expected.getPosterPath(), actual.getPosterPath());
//    }
//}
