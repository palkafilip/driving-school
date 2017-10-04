package com.schooldrive.persistence.user;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Filip on 01.10.2017.
 */

@Repository
@Transactional(isolation = Isolation.READ_COMMITTED)
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    protected EntityManager em;

    public void setEntityManager(EntityManager entityManager) {
        this.em = entityManager;
    }

    public User getUserById(Integer id) {
       return em.find(User.class, id);
    }
}
