package org.example.repository.impl;

import org.example.entity.Manager;
import org.example.repository.ManagerRepo;
import org.example.util.SessionUtil;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class ManagerRepoImpl extends SessionUtil implements ManagerRepo {
    private Session session;

    @Override
    public void add(Manager manager) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.save(manager);
        closeTransactionSesstion();
    }

    @Override
    public List<Manager> getAll() throws SQLException {
        openTransactionSession();
        String hql = "FROM Manager";
        Session session = getSession();
        List<Manager> managers = session.createQuery(hql).list();
        closeTransactionSesstion();
        return managers;
    }

    @Override
    public Manager getById(Long id) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        Manager manager = session.get(Manager.class, id);
        closeTransactionSesstion();
        return manager;
    }

    @Override
    public Manager update(Manager manager) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.saveOrUpdate(manager);
        closeTransactionSesstion();
        return manager;
    }

    @Override
    public void remove(Long id) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        Manager manager = session.get(Manager.class, id);
        session.remove(manager);
        closeTransactionSesstion();
    }
}
