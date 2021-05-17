package org.example.Controller;

import org.example.entity.Manager;
import org.example.repository.ManagerRepo;
import org.example.repository.impl.ManagerRepoImpl;

import java.sql.SQLException;
import java.util.List;

public class ManagerController {
    private ManagerRepo managerRepo = new ManagerRepoImpl();

    public Manager getMangerById(Long id) throws SQLException {
        return managerRepo.getById(id);
    }

    public Manager editManager(Manager manager) throws SQLException {
        return managerRepo.update(manager);
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
