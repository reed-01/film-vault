package org.danielreed.dao;

import org.danielreed.exception.DaoException;
import org.danielreed.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JdbcUserDaoTest extends BaseDaoTest {
    protected static final User USER_1 = new User(1, "user1", "user1", "ROLE_USER", "User One", "123 Test Street", "Testville", "NY", "12345");
    protected static final User USER_2 = new User(2, "user2", "user2", "ROLE_USER", "User Two", "456 Test Street", "Coolville", "NY", "67899");
    private static final User USER_3 = new User(3, "user3", "user3", "ROLE_USER", "User Three", "789 Test Street", "Test Town", "NY", "99876");

    private JdbcUserDao dao;

    @BeforeEach
    public void setup() {
        dao = new JdbcUserDao(dataSource);
    }

    @Test
    public void getUserByUsername_given_null_returns_null_user() {
        User user = dao.getUserByUsername(null);
        assertNull(user, "getUserByUsername with null username did not return null user");
    }

    @Test
    public void getUserByUsername_given_invalid_username_returns_null_user() {
        User user = dao.getUserByUsername("invalid");
        assertNull(user, "getUserByUsername with invalid username did not return null user");
    }

    @Test
    public void getUserByUsername_given_valid_user_returns_correct_user() {
        User actualUser = dao.getUserByUsername(USER_1.getUsername());
        assertUsersMatch(USER_1, actualUser);
    }

    @Test
    public void getUserById_given_invalid_user_id_returns_null() {
        User user = dao.getUserById(-1);
        assertNull(user, "getUserById with invalid userId did not return null user");
    }

    @Test
    public void getUserById_given_valid_user_id_returns_user() {
        User actualUser = dao.getUserById(USER_1.getId());
        assertUsersMatch(USER_1, actualUser);
    }

    @Test
    public void findAll_returns_all_users() {
        List<User> users = dao.getUsers();

        assertNotNull(users, "getUsers returned a null list of users");
        assertEquals(3, users.size(), "getUsers returned a list with the incorrect number of users");
        assertUsersMatch(USER_1, users.get(0));
        assertUsersMatch(USER_2, users.get(1));
        assertUsersMatch(USER_3, users.get(2));
    }

    @Test
    public void create_user_with_null_username() {
        try {
            dao.createUser(new User(null, USER_3.getHashedPassword(), "ROLE_USER", "Name", "Address", "City", "NY", "11111"));
            fail("Expected createUser() with null username to throw DaoException, but it didn't throw any exception");
        } catch (DaoException e) {
            // expected condition
        } catch (Exception e) {
            fail("Expected createUser() with null username to throw DaoException, but threw a different exception");
        }
    }

    @Test
    public void create_user_with_existing_username() {
        try {
            dao.createUser(new User(USER_1.getUsername(), USER_3.getHashedPassword(), "ROLE_USER", "Name", "Address", "City", "NY", "11111"));
            fail("Expected createUser() with existing username to throw DaoException, but it didn't throw any exception");
        } catch (DaoException e) {
            // expected condition
        } catch (Exception e) {
            fail("Expected createUser() with existing username to throw DaoException, but threw a different exception");
        }
    }

    @Test
    public void create_user_with_null_password() {
        try {
            dao.createUser(new User(USER_3.getUsername(), null, "ROLE_USER", "Name", "Address", "City", "NY", "11111"));
            fail("Expected createUser() with null password to throw DaoException, but it didn't throw any exception");
        } catch (DaoException e) {
            // expected condition
        } catch (Exception e) {
            fail("Expected createUser() with null password to throw DaoException, but threw a different exception");
        }
    }

    @Test
    public void create_user_creates_a_user() {
        User newUser = new User("new", "user", "ROLE_USER", "New Name", "123 New Street", "Big Apple", "NY", "12345");

        User user = dao.createUser(newUser);
        assertNotNull(user, "Call to create should return non-null user");

        User actualUser = dao.getUserById(user.getId());
        assertNotNull(actualUser, "Call to getUserById after call to create should return non-null user");

        newUser.setId(actualUser.getId());
        actualUser.setHashedPassword(newUser.getHashedPassword()); // reset password back to unhashed password for testing
        assertEquals(newUser, actualUser);
    }

    private void assertUsersMatch(User expected, User actual) {
        assertNotNull(actual, "Actual user was null");
        assertEquals(expected.getId(), actual.getId(), "id does not match");
        assertEquals(expected.getUsername(), actual.getUsername(), "username does not match");
        assertEquals(expected.getHashedPassword(), actual.getHashedPassword(), "password_hash does not match");
        assertEquals(expected.getRole(), actual.getRole(), "role does not match");
        assertEquals(expected.getName(), actual.getName(), "name does not match");
        assertEquals(expected.getAddress(), actual.getAddress(), "address does not match");
        assertEquals(expected.getCity(), actual.getCity(), "city does not match");
        assertEquals(expected.getStateCode(), actual.getStateCode(), "state_code does not match");
        assertEquals(expected.getZipCode(), actual.getZipCode(), "zip_code does not match");
    }
}
