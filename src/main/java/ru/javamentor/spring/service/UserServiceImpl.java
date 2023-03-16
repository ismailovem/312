package ru.javamentor.spring.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.javamentor.spring.dao.Dao;
import ru.javamentor.spring.model.User;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final Dao dao;
    public UserServiceImpl(Dao dao) {
        this.dao = dao;
    }
    @Transactional
    @Override
    public void save(User user) {
        dao.save(user);
    }
    @Override
    public User findById(Long id) { return dao.findById(id); }
    @Override
    public List<User> getAll() {
        return dao.getAll();
    }
    @Transactional
    @Override
    public void update(User user,Long id) { dao.update(user,id);  }
    @Transactional
    @Override
    public void removeById(Long id) {
        dao.removeById(id);
    }
}