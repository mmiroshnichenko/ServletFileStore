package org.mmyroshnychenko.repository.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.mmyroshnychenko.model.Event;
import org.mmyroshnychenko.model.File;
import org.mmyroshnychenko.model.User;
import org.mmyroshnychenko.repository.EventRepository;
import org.mmyroshnychenko.utils.HibernateUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class HibernateEventRepositoryImpl implements EventRepository {
    @Override
    public Event getById(Long id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Event event = session.get(Event.class, id);
        session.close();
        return event;
    }

    @Override
    public List<Event> getAll() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<Event> events = session.createQuery("FROM Event").list();
        session.close();
        return events;
    }

    @Override
    public List<Event> getByUserAndFile(User user, File file) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Event.class);
        if (user != null) {
            criteria.add(Restrictions.eq("user", user));
        }
        if (file != null) {
            criteria.add(Restrictions.eq("file", file));
        }
        List<Event> events = criteria.list();
        session.close();
        return events;
    }

    @Override
    public Event save(Event event) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(event);
        transaction.commit();
        session.close();
        return event;
    }

    @Override
    public Event update(Event event) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(event);
        transaction.commit();
        session.close();
        return event;
    }

    @Override
    public void deleteById(Long id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Event event = session.get(Event.class, id);
        session.delete(event);
        transaction.commit();
        session.close();
    }
}
