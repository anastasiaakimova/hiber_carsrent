package org.example.repository.impl;

import org.example.entity.Client;
import org.example.entity.Contract;
import org.example.repository.ClientRepo;
import org.example.util.SessionUtil;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class ClientRepoImpl extends SessionUtil implements ClientRepo {

    private Session session;

    @Override
    public void add(Client client) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.save(client);
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
        openTransactionSession();
        Session session = getSession();
        Client client = session.get(Client.class, id);
        closeTransactionSesstion();
        return client;
    }

    @Override
    public Client update(Client client) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.saveOrUpdate(client);
        closeTransactionSesstion();
        return client;
    }

    @Override
    public void remove(Long id) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        Client client = session.get(Client.class, id);
        session.remove(client);
        closeTransactionSesstion();
    }

//    public List<Contract> readContractList(Client client){
//        Collection<Contract> contract = client.getContractsById();
//        List<Contract> contracts = new LinkedList<>();
//        for(Contract c : contract){
//            contracts.add(c.getClientByClient());
//        }
//        return contracts;
//    }
}