package ru.javamentor.spring.dao;

import org.springframework.stereotype.Repository;
import ru.javamentor.spring.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class DaoImpl implements Dao {
    @PersistenceContext
    private EntityManager em;
    @Override
    public void save(User user) { em.persist(user);}
    @Override
    public void update(User user,Long id) {
        User user1 = findById(id);
        user1.setName(user.getName());
        user1.setLastName(user.getLastName());
    }
    @Override
    public User findById(Long id) { return em.find(User.class, id); }
    @Override
    public List<User> getAll() {return em.createQuery("FROM User",User.class).getResultList();}
    @Override
    public void removeById(Long id) { em.remove(em.find(User.class, id));}
}

