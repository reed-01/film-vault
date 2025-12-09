package org.danielreed.dao;

import org.danielreed.model.RegisterUserDto;
import org.danielreed.model.User;

import java.util.List;

public interface UserDao {

    List<User> getUsers();

    User getUserById(int id);

    User getUserByUsername(String username);

    User createUser(RegisterUserDto user);
}
