package org.example.view;

import java.sql.SQLException;
import java.util.Scanner;

public class CommonView {

    private ClientView clientView;

    private static CommonView view;

    private CommonView() {

        clientView = new ClientView();
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
            System.out.println("\nChoose file in order to do operations , please :");
            System.out.println("Enter number : ");
            System.out.println("1. Client");

            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    runClient();
                    break;
//                case 2:
//                    runComment();
//                    break;
//                case 3:
//                    runUser();
//                    break;
//                case 4:
//                    go = false;
//                    break;
                default:
                    System.out.println("Wrong number");
                    System.out.println("Enter number from 1 to 4, please");
            }
        }
    }
    public void runClient() throws SQLException {
        clientView.run();
    }
//    public void runComment() {
//        commentView.run();
//    }
//
//    public void runUser() {
//        userView.run();
//    }

}

