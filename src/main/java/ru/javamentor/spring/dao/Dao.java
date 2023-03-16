package ru.javamentor.spring.dao;

import ru.javamentor.spring.model.User;

import java.util.List;

public interface Dao {
    User findById(Long id);
    void save(User user);
    void update(User user,Long id);
    void removeById(Long id);
    List<User> getAll();
}
