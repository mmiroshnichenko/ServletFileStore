package org.mmyroshnychenko.repository.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mmyroshnychenko.model.File;
import org.mmyroshnychenko.model.User;
import org.mmyroshnychenko.repository.FileRepository;
import org.mmyroshnychenko.utils.HibernateUtils;

import java.util.List;

public class HibernateFileRepositoryImpl implements FileRepository {
    @Override
    public File getById(Long id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        File file = session.get(File.class, id);
        session.close();
        return file;
    }

    @Override
    public File getByNameAndPath(String name, String path) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Query query = session.createQuery("FROM File WHERE name = :name AND path = :path");
        query.setParameter("name", name);
        query.setParameter("path", path);
        List<File> files = query.list();
        if (files.size() > 0) {
            return files.get(0);
        }
        return null;
    }

    @Override
    public List<File> getAll() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<File> files = session.createQuery("FROM File").list();
        session.close();
        return files;
    }

    @Override
    public File save(File file) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(file);
        transaction.commit();
        session.close();
        return file;
    }

    @Override
    public File update(File file) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(file);
        transaction.commit();
        session.close();
        return file;
    }

    @Override
    public void deleteById(Long id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        File file = session.load(File.class, id);
        session.delete(file);
        transaction.commit();
        session.close();
    }
}
