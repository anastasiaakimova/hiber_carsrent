package org.example.controller;

import org.example.entity.Client;
import org.example.repository.GenericRepo;
import org.example.repository.impl.ClientRepoImpl;

import java.sql.SQLException;
import java.util.List;

public class ClientController {
    private GenericRepo clientRepo = new ClientRepoImpl();

    public Client getClientById(Long id) throws SQLException {
        return (Client)clientRepo.getById(id);
    }

    public Client editClient(Client client) throws SQLException {
        return (Client)clientRepo.update(client);
    }


    public List<Client> getAllClients() throws SQLException {
        return clientRepo.getAll();
    }

    public void saveClient(Client client) throws SQLException {
        clientRepo.add(client);
    }

    public void deleteClient(Long id) throws SQLException{
        clientRepo.remove(id);
    }
}
