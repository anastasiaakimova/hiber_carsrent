package org.example.repository.impl;

import org.example.entity.Client;
import org.example.repository.ClientRepo;
import org.example.util.SessionUtil;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class ClientRepoImpl extends SessionUtil implements ClientRepo {

    private Session session;

    @Override
    public void add(Client client) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.save(client);

        //close session with a transaction
        closeTransactionSesstion();
    }

    @Override
    public List<Client> getAll() throws SQLException {
        openTransactionSession();
        String hql = "FROM Client";
        Session session = getSession();
        List<Client> clients = session.createQuery(hql).list();
        closeTransactionSesstion();
        return clients;
    }

    @Override
    public Client getById(Long id) throws SQLException {
        //open session with a transaction
        openTransactionSession();
        Session session = getSession();
        Client client = session.get(Client.class, id);
        //close session with a transaction
        closeTransactionSesstion();
        return client;
    }

    @Override
    public Client update(Client client) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.saveOrUpdate(client);

        //close session with a transaction
        closeTransactionSesstion();
        return client;
    }

    @Override
    public void remove(Long id) throws SQLException {
        //open session with a transaction
        openTransactionSession();
        Session session = getSession();
        Client client = session.get(Client.class, id);
        session.remove(client);
        //close session with a transaction
        closeTransactionSesstion();
    }
}