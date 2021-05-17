package org.example.repository;

import org.example.entity.Contract;

import java.sql.SQLException;
import java.util.List;

public interface ContractRepo {
    //create
    void add(Contract contract) throws SQLException;

    //read
    List<Contract> getAll() throws SQLException;

    Contract getById(Long id) throws SQLException;

    //update
    Contract update(Contract contract) throws SQLException;

    //delete
    void remove(Long id) throws SQLException;
}
