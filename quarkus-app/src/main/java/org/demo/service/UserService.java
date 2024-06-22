package org.demo.service;

import org.demo.entities.User;

import java.util.List;

public interface UserService {

    List<User> getAllUser();
    User createUser(User user);
    User getUserById(long id);

    User updateUserById(long id, User user);

    void deleteUserById(long id);

}
