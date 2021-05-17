package org.example.Controller;

import org.example.entity.Contract;
import org.example.repository.ContractRepo;
import org.example.repository.impl.ContractRepoImpl;

import java.sql.SQLException;
import java.util.List;

public class ContractController {
    private ContractRepo contractRepo = new ContractRepoImpl();

    public Contract getContractById(Long id) throws SQLException {
        return contractRepo.getById(id);
    }

    public Contract editContract(Contract contract) throws SQLException {
        return contractRepo.update(contract);
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
