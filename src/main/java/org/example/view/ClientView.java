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
    private Scanner scanner2 = new Scanner(System.in);
    private Scanner scanner3 = new Scanner(System.in);
    private Scanner scanner4 = new Scanner(System.in);
    private ClientController clientController = new ClientController();

    public void showClients() throws SQLException {
        List<Client> clients = clientController.getAllClients();
        System.out.println("Список клиентов: ");
        clients.forEach(client1 -> System.out.println(client1.toString()));
    }

    public void saveClient() {
        try {
            Client newClient = new Client();

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

            clientController.saveClient(newClient);
        } catch (
                InputMismatchException | SQLException e) {
            System.out.print(e.getMessage());
        }
    }

    public void deleteClient() throws SQLException {
        System.out.println("Введите id клиента, которого хотите удалить : ");
        Long id = Long.parseLong(scanner.next());
        clientController.deleteClient(id);
    }

    public void updateClient() throws SQLException {
        try {
            System.out.println("Введите id клиента, информацию которого хотите изменить:");
            Long id = Long.parseLong(scanner2.next());

            Client newClient;
            newClient =clientController.getClientById(id);

            System.out.println("Введите имя :");
            String firstName = scanner3.nextLine();
            newClient.setFirstName(firstName);

            System.out.println("Введите фамилию :");
            String lastName = scanner3.nextLine();
            newClient.setLastName(lastName);

            System.out.println("Введите пароль :");
            String password = scanner3.nextLine();
            newClient.setPassword(password);

            System.out.println("Введите адрес :");
            String address = scanner3.nextLine();
            newClient.setAddress(address);

            System.out.println("Введите номер телефона:");
            String phoneNumber = scanner3.nextLine();
            newClient.setPhoneNumber(phoneNumber);

            clientController.editClient(newClient);
        } catch (InputMismatchException e) {
            System.out.print(e.getMessage());
        }
    }

    public void getByIdClient() throws SQLException {
        System.out.println("введите id клиента которго хотите найти:");
        Long id = Long.parseLong(scanner.next());
        try {
            if (clientController.getClientById(id) != null){
                System.out.println(clientController.getClientById(id).toString());}

            else {
                System.out.println("Такого клиента не существует в базе");
            }

        } catch (NullPointerException | SQLException e) {
            System.out.println("Это не число ");
            System.out.println("Попробуйте еще раз, пожалуйста");
            getByIdClient();
        }
    }

    public void run() throws SQLException {
        boolean go = true;
        while (go) {
            System.out.println("\n Выберите опцию, пожалуйста :");
            System.out.println(" Введите число : ");
            System.out.println(" 1. Показать всех клиентов");
            System.out.println(" 2. Добавить нового клиента");
            System.out.println(" 3. Удалить клиента ");
            System.out.println(" 4. Обновить информацию о клиенте  ");
            System.out.println(" 5. Найти по id");
            System.out.println(" 6. Выйти ");
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
                    System.out.println("Неверное число!");
                    System.out.println("Введите число от 1 до 6, пожалуйста");
            }
        }
    }
}
