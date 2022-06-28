package org.mmyroshnychenko.repository.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mmyroshnychenko.model.User;
import org.mmyroshnychenko.repository.UserRepository;
import org.mmyroshnychenko.utils.HibernateUtils;

import java.util.List;

public class HibernateUserRepositoryImpl implements UserRepository {
    @Override
    public User getById(Long id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

    @Override
    public User getByUsername(String username) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Query query = session.createQuery("FROM User WHERE username = :username");
        query.setParameter("username", username);
        List<User> users = query.list();
        if (users.size() > 0) {
            return users.get(0);
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<User> users = session.createQuery("FROM User").list();
        session.close();
        return users;
    }

    @Override
    public User save(User user) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
        return user;
    }

    @Override
    public User update(User user) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
        return user;
    }

    @Override
    public void deleteById(Long id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        User user = session.load(User.class, id);
        session.delete(user);
        transaction.commit();
        session.close();
    }
}
