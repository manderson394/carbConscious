package com.mattanderson.carbConscious.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import com.mattanderson.carbConscious.entity.User;

public class UserDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    public User getById(int id) {

    }

    public User getByUsername(String username) {

    }

    public User getByEmail(String email) {

    }

    public void saveOrUpdate(User user) {

    }

    public int insert(User user) {

    }

    public void delete(User user) {

    }
}
