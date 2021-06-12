package org.example.controller;

import org.example.entity.Manager;
import org.example.repository.GenericRepo;
import org.example.repository.impl.ManagerRepoImpl;

import java.sql.SQLException;
import java.util.List;

public class ManagerController {
    private GenericRepo managerRepo = new ManagerRepoImpl();

    public Manager getMangerById(Long id) throws SQLException {
        return (Manager)managerRepo.getById(id);
    }

    public Manager editManager(Manager manager) throws SQLException {
        return (Manager)managerRepo.update(manager);
    }


    public List<Manager> getAllClients() throws SQLException {
        return managerRepo.getAll();
    }

    public void saveManager(Manager manager) throws SQLException {
        managerRepo.add(manager);
    }

    public void deleteManager(Long id) throws SQLException {
        managerRepo.remove(id);
    }
}
