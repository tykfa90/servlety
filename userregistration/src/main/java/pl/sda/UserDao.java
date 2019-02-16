package pl.sda;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Collection;

@Singleton
public class UserDao {

    @PersistenceContext(unitName = "testPersistenceUnit")
    private EntityManager entityManager;

    @Transactional
    void saveUser(User user) {
        entityManager.persist(user);
    }

    Collection<User> getUsers() {
        Query query = entityManager.createQuery("select u from User u");
        return query.getResultList();
    }

    User findById(Long userId) {
        return entityManager.find(User.class, userId);
    }
}
