package org.example.repository.impl;

import org.example.entity.Car;
import org.example.entity.Client;
import org.example.repository.CarRepo;
import org.example.util.SessionUtil;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class CarRepoImpl extends SessionUtil implements CarRepo {

    private Session session;

    @Override
    public void add(Car car) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.save(car);
        closeTransactionSesstion();
    }

    @Override
    public List<Car> getAll() throws SQLException {
        openTransactionSession();
        String hql = "FROM Car";
        Session session = getSession();
        List<Car> cars = session.createQuery(hql).list();
        closeTransactionSesstion();
        return cars;
    }

    @Override
    public Car getById(Long id) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        Car car = session.get(Car.class, id);
        closeTransactionSesstion();
        return car;
    }

    @Override
    public Car update(Car car) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.saveOrUpdate(car);
        closeTransactionSesstion();
        return car;
    }

    @Override
    public void remove(Long id) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        Car car = session.get(Car.class, id);
        session.remove(car);
        closeTransactionSesstion();
    }
}
