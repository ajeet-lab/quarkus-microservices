package org.demo.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.demo.daos.UserDao;
import org.demo.entities.User;
import org.demo.service.UserService;

import java.util.List;

@ApplicationScoped
public class UserServiceImpl implements UserService {
    @Inject
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao){
        this.userDao=userDao;
    }

    @Override
    public List<User> getAllUser() {
        return userDao.listAll();
    }

    @Override
    public User createUser(User user) {
        userDao.persist(user);
        if(userDao.isPersistent(user)){
            return user;
        }
        return user;
    }

    @Override
    public User getUserById(long id) {
        return userDao.findById(id);
    }

    @Override
    public User updateUserById(long id, User user) {
        User user1 = userDao.findById(id);
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());
        user1.setAbout(user.getAbout());
        userDao.persist(user1);
        if (userDao.isPersistent(user)){
            return userDao.findById(id);
        }
        return userDao.findById(id);
    }

    @Override
    public void deleteUserById(long id) {
        userDao.deleteById(id);
    }
}
