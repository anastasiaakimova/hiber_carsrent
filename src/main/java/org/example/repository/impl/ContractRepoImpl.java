package org.example.repository.impl;

import org.example.entity.Contract;
import org.example.repository.ContractRepo;
import org.example.util.SessionUtil;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class ContractRepoImpl extends SessionUtil implements ContractRepo {
    private Session session;

    @Override
    public void add(Contract contract) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.save(contract);
        closeTransactionSesstion();
    }

    @Override
    public List<Contract> getAll() throws SQLException {
        openTransactionSession();
        String hql = "FROM Contract ";
        Session session = getSession();
        List<Contract> contracts = session.createQuery(hql).list();
        closeTransactionSesstion();
        return contracts;
    }

    @Override
    public Contract getById(Long id) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        Contract contract = session.get(Contract.class, id);
        closeTransactionSesstion();
        return contract;
    }

    @Override
    public Contract update(Contract contract) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.saveOrUpdate(contract);
        closeTransactionSesstion();
        return contract;
    }

    @Override
    public void remove(Long id) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        Contract contract = session.get(Contract.class, id);
        session.remove(contract);
        closeTransactionSesstion();
    }
}
