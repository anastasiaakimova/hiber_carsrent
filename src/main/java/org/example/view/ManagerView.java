package org.example.view;

import org.example.controller.ClientController;
import org.example.controller.ManagerController;
import org.example.entity.Client;
import org.example.entity.Manager;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ManagerView {

    private ManagerController managerController = new ManagerController();

    public void showManagers() throws SQLException {
        List<Manager> managers = managerController.getAllClients();
        System.out.println("Список менеджеров: ");
        managers.forEach(manager1 -> System.out.println(manager1.toString()));
    }

    public void saveManager() {
        try {
            Scanner scanner = new Scanner(System.in);
            Manager newManager = new Manager();

            System.out.println("Введите имя :");
            String firstName = scanner.nextLine();
            newManager.setFirstName(firstName);

            System.out.println("Введите фамилию :");
            String lastName = scanner.nextLine();
            newManager.setLastName(lastName);

            System.out.println("Введите номер телефона:");
            String phoneNumber = scanner.nextLine();
            newManager.setPhoneNumber(phoneNumber);

            managerController.saveManager(newManager);
        } catch (
                InputMismatchException | SQLException e) {
            System.out.print(e.getMessage());
        }
    }

    public void deleteManager() throws SQLException {
        System.out.println("Введите id менеджера, которого хотите удалить : ");
        Scanner scanner = new Scanner(System.in);
        Long id = Long.parseLong(scanner.next());
        managerController.deleteManager(id);
    }

    public void updateManager() throws SQLException {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите id менеджера, информацию которого хотите изменить:");
            Long id = Long.parseLong(scanner.next());

            Manager newManager;
            newManager =managerController.getMangerById(id);

            System.out.println("Введите имя :");
            String firstName = scanner.nextLine();
            newManager.setFirstName(firstName);

            System.out.println("Введите фамилию :");
            String lastName = scanner.nextLine();
            newManager.setLastName(lastName);

            System.out.println("Введите номер телефона:");
            String phoneNumber = scanner.nextLine();
            newManager.setPhoneNumber(phoneNumber);

            managerController.editManager(newManager);
        } catch (InputMismatchException e) {
            System.out.print(e.getMessage());
        }
    }

    public void getByIdManager() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите id менеджера которго хотите найти:");
        Long id = Long.parseLong(scanner.next());
        try {
            if (managerController.getMangerById(id) != null){
                System.out.println(managerController.getMangerById(id).toString());}

            else {
                System.out.println("Такого менеджера не существует в базе");
            }

        } catch (NullPointerException | SQLException e) {
            System.out.println("Это не число ");
            System.out.println("Попробуйте еще раз, пожалуйста");
            getByIdManager();
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
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    showManagers();
                    break;
                case 2:
                    saveManager();
                    break;
                case 3:
                    deleteManager();
                    break;
                case 4:
                    updateManager();
                    break;
                case 5:
                    getByIdManager();
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
