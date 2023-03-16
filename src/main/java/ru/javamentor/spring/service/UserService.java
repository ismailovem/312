package ru.javamentor.spring.service;



import ru.javamentor.spring.model.User;

import java.util.List;

public interface UserService {
    void save(User user);
    User findById(Long id);
    void removeById(Long id);
    List<User> getAll();
    void update(User user,Long id);
}
