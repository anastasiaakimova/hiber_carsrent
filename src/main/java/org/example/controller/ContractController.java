package org.example.controller;

import org.example.entity.Contract;
import org.example.repository.GenericRepo;
import org.example.repository.impl.ContractRepoImpl;

import java.sql.SQLException;
import java.util.List;

public class ContractController {
    private GenericRepo contractRepo = new ContractRepoImpl();

    public Contract getContractById(Long id) throws SQLException {
        return (Contract)contractRepo.getById(id);
    }

    public Contract editContract(Contract contract) throws SQLException {
        return (Contract)contractRepo.update(contract);
    }


    public List<Contract> getAllContracts() throws SQLException {
        return contractRepo.getAll();
    }

    public void saveContract(Contract contract) throws SQLException {
        contractRepo.add(contract);
    }

    public void deleteContract(Long id) throws SQLException {
        contractRepo.remove(id);
    }
}
