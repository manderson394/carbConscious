package com.mattanderson.carbConscious.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.mattanderson.carbConscious.entity.User;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Facilitates transactions between the web application and the database for the <code>User</code>
 * class (data access object).
 * @author Matt Anderson
 * @version 11
 */
public class UserDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Gets the user by id.
     *
     * @param id the id
     * @return the by id
     */
    public User getById(int id) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

    /**
     * Gets a User from the database depending on the user property and criteria passed in.
     * This should be used to search for a user by email or username.
     *
     * @param propertyName  the property name
     * @param propertyValue the property value
     * @return the by property equal
     */
    public List<User> getByPropertyEqual(String propertyName, String propertyValue) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for user with " + propertyName + " = " + propertyValue);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery( User.class );
        Root<User> root = query.from( User.class );
        query.select(root).where(builder.equal(root.get(propertyName), propertyValue));
        List<User> users = session.createQuery( query ).getResultList();

        session.close();
        return users;

    }

    /**
     * Save or update as user in the database.
     *
     * @param user the user
     */
    public void saveOrUpdate(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(user);
        transaction.commit();
        session.close();
    }

    /**
     * Insert a User into the database.
     *
     * @param user the user
     * @return the user id
     */
    public int insert(User user) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(user);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete a User from the database.
     *
     * @param user the user
     */
    public void delete(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }
}
