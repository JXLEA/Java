package com.ua.education.service;

import com.ua.education.dao.UserDao;
import com.ua.education.model.User;

import java.util.List;
import java.util.Objects;

public class UserService {

    private UserDao userDao;

    public User getUserById(long userId) {
        return userDao.getUserById(userId);
    }

    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        return userDao.getUserByName(name, pageSize, pageNum);
    }

    public User create(User user) {
        return userDao.put(user);
    }

    public User update(User user) {
        return userDao.put(user);
    }

    public boolean delete(long userId) {
        return Objects.nonNull(userDao.delete(userId));
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
