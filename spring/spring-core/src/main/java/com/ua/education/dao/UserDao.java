package com.ua.education.dao;

import com.ua.education.model.User;
import com.ua.education.repository.Storage;

import java.util.List;
import java.util.stream.Collectors;

public class UserDao {

    private Storage storage;

    public User getUserById(long userId) {
        return storage.getUserStorage().get(String.format("user: %s", userId));
    }

    public User getUserByEmail(String email) {
        return storage.getUserStorage().values().stream()
                .filter(user -> email.equals(user.getEmail())).findAny().orElse(null);
    }

    public List<User> getUserByName(String name, int pageSize, int pageNum) {
        int indexFrom = pageNum * pageSize;
        return storage.getUserStorage().values()
                .stream()
                .filter(user -> name.equals(user.getEmail()))
                .collect(Collectors.toList())
                .subList(indexFrom, indexFrom + pageSize);
    }

    public User put(User user) {
        user.setId(user.getId() == 0 ? storage.getTicketStorage().values().size() + 1 : user.getId());
        return storage.getUserStorage().put(String.format("user: %s", user.getId()), user);
    }

    public User delete(long userId) {
        return storage.getUserStorage().remove(String.format("user: %s", userId));
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }
}
