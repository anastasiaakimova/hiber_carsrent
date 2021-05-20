package org.example.view;

import java.sql.SQLException;
import java.util.Scanner;

public class CommonView {

    private ClientView clientView;
    private static CommonView view;
    private static CarView carView;
    private static ManagerView managerView;
    private static ContractView contractView;

    private CommonView() {
        clientView = new ClientView();
        carView = new CarView();
    }

    public static CommonView getInstance() {
        if (view == null) {
            view = new CommonView();
        }
        return view;
    }

    public void run() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        boolean go = true;
        while (go) {
            System.out.println("\nВыберите опцию для операции: ");
            System.out.println("Введите число : ");
            System.out.println("1. Клиент");
            System.out.println("2. Машина");
            System.out.println("3. Менаджер");
            System.out.println("4. Контракт");
            System.out.println("5. Выход");

            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    runClient();
                    break;
                case 2:
                    runCar();
                    break;
                case 3:
                    runManager();
                    break;
                case 4:
                    runContract();
                    break;
                case 5:
                    go = false;
                    break;
                default:
                    System.out.println("Не верное число");
                    System.out.println("Введите числа от 1 до 4, пожалуйста");
            }
        }
    }

    private void runManager() throws SQLException {
        managerView.run();
    }

    private void runContract() throws SQLException {
        contractView.run();
    }

    public void runClient() throws SQLException {
        clientView.run();
    }

    public void runCar() throws SQLException {
        carView.run();
    }
}

