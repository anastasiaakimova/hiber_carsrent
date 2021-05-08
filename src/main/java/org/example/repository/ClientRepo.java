package org.example.repository;

import org.example.entity.Client;

import java.sql.SQLException;
import java.util.List;

public interface ClientRepo {
    //create
    void add(Client client) throws SQLException;

    //read
    List<Client> getAll() throws SQLException;

    Client getById(Long id) throws SQLException;

    //update
    Client update(Client client) throws SQLException;

    //delete
    void remove(Long id) throws SQLException;

}
