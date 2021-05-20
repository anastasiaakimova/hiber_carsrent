package org.example.view;

import java.sql.SQLException;
import java.util.Scanner;

public class View {

    private ClientView clientView;
    private static View view;
    private static CarView carView;
    private static ManagerView managerView;

    private View() {
        clientView = new ClientView();
        carView = new CarView();
        managerView = new ManagerView();
    }

    public static View getInstance() {
        if (view == null) {
            view = new View();
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
            System.out.println("4. Выход");

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


    public void runClient() throws SQLException {
        clientView.run();
    }

    public void runCar() throws SQLException {
        carView.run();
    }
}

