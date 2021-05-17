package org.example.repository;

import org.example.entity.Manager;

import java.sql.SQLException;
import java.util.List;

public interface ManagerRepo {
    //create
    void add(Manager manager) throws SQLException;

    //read
    List<Manager> getAll() throws SQLException;

    Manager getById(Long id) throws SQLException;

    //update
    Manager update(Manager manager) throws SQLException;

    //delete
    void remove(Long id) throws SQLException;
}
