package org.example.repository.impl;

import org.example.entity.Car;
import org.example.repository.CarRepo;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class CarRepoImpl implements CarRepo {

    private Session session;
    private Transaction transaction;

    @Override
    public void add(Car car) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.save(car);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Car> getAll() throws SQLException {
      session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        String hql = "FROM Car";
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Car> cars = session.createQuery(hql).list();
        transaction.commit();
        session.close();
        return cars;
    }

    @Override
    public Car getById(Long id) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Car car = session.get(Car.class, id);
        transaction.commit();
        session.close();
        return car;
    }

    @Override
    public Car update(Car car) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.saveOrUpdate(car);
        transaction.commit();
        session.close();
        return car;
    }

    @Override
    public void remove(Long id) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Car car = session.get(Car.class, id);
        session.remove(car);
        transaction.commit();
        session.close();
    }
}
