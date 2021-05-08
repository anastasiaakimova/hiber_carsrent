package org.example.view;

import org.example.Controller.ClientController;
import org.example.entity.Client;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ClientView {
    private Scanner scanner = new Scanner(System.in);
    private Scanner scanner1 = new Scanner(System.in);
    private ClientController clientController = new ClientController();

    public void showClients() throws SQLException {
        List<Client> clients = clientController.getAllClients();
        System.out.println("List of all clients : ");
        clients.forEach(client1 -> System.out.println(client1.toString()));
    }

    public void saveClient() {
        try {
            Client newClient = new Client();

            System.out.println("Введите имя :");
            String firstName = scanner.nextLine();
            newClient.setFirstName(firstName);

            System.out.println("Введите фамилию :");
            String lastName = scanner.nextLine();
            newClient.setLastName(lastName);

            System.out.println("Введите пароль :");
            String password = scanner.nextLine();
            newClient.setPassword(password);

            System.out.println("Введите адрес :");
            String address = scanner.nextLine();
            newClient.setAddress(address);

            System.out.println("Введите номер телефона:");
            String phoneNumber = scanner1.nextLine();
            newClient.setPhoneNumber(phoneNumber);

            clientController.saveClient(newClient);
        } catch (
                InputMismatchException | SQLException e) {
            System.out.print(e.getMessage());
        }
    }

    public void deleteClient() throws SQLException {
        System.out.println("Enter id delete client : ");
        Long id = Long.parseLong(scanner.next());
        clientController.deleteClient(id);
    }

    public void updateClient() throws SQLException {
        try {
            System.out.println("Enter id in order to find element :");
            Long id = Long.parseLong(scanner.next());

            Client newClient = new Client();
            newClient =clientController.getClientById(id);

            System.out.println("Введите имя :");
            String firstName = scanner1.nextLine();
            newClient.setFirstName(firstName);

            System.out.println("Введите фамилию :");
            String lastName = scanner1.nextLine();
            newClient.setLastName(lastName);

            System.out.println("Введите пароль :");
            String password = scanner1.nextLine();
            newClient.setPassword(password);

            System.out.println("Введите адрес :");
            String address = scanner1.nextLine();
            newClient.setAddress(address);

            System.out.println("Введите номер телефона:");
            String phoneNumber = scanner1.nextLine();
            newClient.setPhoneNumber(phoneNumber);

            clientController.editClient(newClient);
        } catch (InputMismatchException e) {
            System.out.print(e.getMessage());
        }
    }

    public void getByIdClient() throws SQLException {
        System.out.println("Enter id in order to get user :");
        Long id = Long.parseLong(scanner.next());
        try {
            if (clientController.getClientById(id) != null)
                System.out.println(clientController.getClientById(id).toString());

        } catch (NullPointerException | SQLException e) {
            System.out.println("There is no such number ");
            System.out.println("Try one more time, please");
            getByIdClient();
        }
    }

    public void run() throws SQLException {
        boolean go = true;
        while (go) {
            System.out.println("\n Choose option, please :");
            System.out.println(" Enter number : ");
            System.out.println(" 1. Show all rows");
            System.out.println(" 2. Insert new row");
            System.out.println(" 3. Delete row ");
            System.out.println(" 4. Update row  ");
            System.out.println(" 5. Search by id ");
            System.out.println(" 6. End ");
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    showClients();
                    break;
                case 2:
                    saveClient();
                    break;
                case 3:
                    deleteClient();
                    break;
                case 4:
                    updateClient();
                    break;
                case 5:
                    getByIdClient();
                    break;
                case 6:
                    go = false;
                    break;
                default:
                    System.out.println("Wrong number");
                    System.out.println("Enter number from 1 to 6, please");
            }
        }
    }
}
