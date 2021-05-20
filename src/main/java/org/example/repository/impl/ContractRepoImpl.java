package org.example.repository.impl;

import org.example.entity.Contract;
import org.example.repository.ContractRepo;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class ContractRepoImpl implements ContractRepo {
    private Session session;
    private Transaction transaction;

    @Override
    public void add(Contract contract) throws SQLException {
       // openTransactionSession();
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();

        // Session session = getSession();
        session.save(contract);
       // closeTransactionSesstion();
        transaction.commit();
        session.close();
    }

    @Override
    public List<Contract> getAll() throws SQLException {
       // openTransactionSession();
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();

        String hql = "FROM Contract ";

       // Session session = getSession();
        List<Contract> contracts = session.createQuery(hql).list();
     //   closeTransactionSesstion();
        transaction.commit();
        session.close();
        return contracts;
    }

    @Override
    public Contract getById(Long id) throws SQLException {
     //   openTransactionSession();
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();

        //  Session session = getSession();
        Contract contract = session.get(Contract.class, id);
       // closeTransactionSesstion();
        transaction.commit();
        session.close();
        return contract;
    }

    @Override
    public Contract update(Contract contract) throws SQLException {
     //   openTransactionSession();
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();

        //   Session session = getSession();

        session.saveOrUpdate(contract);
     //   closeTransactionSesstion();
        transaction.commit();
        session.close();
        return contract;
    }

    @Override
    public void remove(Long id) throws SQLException {
      //  openTransactionSession();
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();

        //  Session session = getSession();
        Contract contract = session.get(Contract.class, id);
        session.remove(contract);
       // closeTransactionSesstion();
        transaction.commit();
        session.close();
    }
}
