package org.example.repository;

import org.example.entity.Car;

import java.sql.SQLException;
import java.util.List;

public interface CarRepo {
    //create
    void add(Car car) throws SQLException;

    //read
    List<Car> getAll() throws SQLException;

    Car getById(Long id) throws SQLException;

    //update
    Car update(Car car) throws SQLException;

    //delete
    void remove(Long id) throws SQLException;
}
