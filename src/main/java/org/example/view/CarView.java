package org.example.view;

import org.example.Controller.CarController;
import org.example.entity.Car;
import org.example.entity.Client;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CarView {
    private Scanner scanner = new Scanner(System.in);
    private Scanner scanner1 = new Scanner(System.in);
    private Scanner scanner2 = new Scanner(System.in);
    private Scanner scanner3 = new Scanner(System.in);
    private Scanner scanner4 = new Scanner(System.in);
    private CarController carController = new CarController();

    private void getByIdCar() throws SQLException {
        System.out.println("Enter id in order to get car :");
        Long id = Long.parseLong(scanner.next());
        try {
            if (carController.getCarById(id) != null){
                System.out.println(carController.getCarById(id).toString());}

            else {
                System.out.println("This id is doesn't exist");
            }

        } catch (NullPointerException | SQLException e) {
            System.out.println("There is no such number ");
            System.out.println("Try one more time, please");
            getByIdCar();
        }
    }

    private void updateCar() throws SQLException{
        try {
            System.out.println("Enter id in order to find element :");
            Long id = Long.parseLong(scanner2.next());

            Car newCar;
            newCar =carController.getCarById(id);

            System.out.println("Введите модель :");
            String model = scanner3.nextLine();
            newCar.setModel(model);

            System.out.println("Введите цвет :");
            String color = scanner3.nextLine();
            newCar.setColor(color);

            System.out.println("Введите цену :");
            String price = scanner3.nextLine();
            newCar.setPrice(Integer.valueOf(price));

            System.out.println("Введите мощность :");
            String availability = scanner3.nextLine();
            newCar.setAvailability(Integer.valueOf(availability));

            carController.editCar(newCar);
        } catch (InputMismatchException e) {
            System.out.print(e.getMessage());
        }
    }

    private void deleteCar() throws SQLException{
        System.out.println("Enter id delete car : ");
        Long id = Long.parseLong(scanner.next());
        carController.deleteCar(id);
    }

    private void saveCar() throws SQLException{
        try {
            Car newCar = new Car();

            System.out.println("Введите модель :");
            String model = scanner3.nextLine();
            newCar.setModel(model);

            System.out.println("Введите цвет :");
            String color = scanner3.nextLine();
            newCar.setColor(color);

            System.out.println("Введите цену :");
            String price = scanner3.nextLine();
            newCar.setPrice(Integer.valueOf(price));

            System.out.println("Введите мощность :");
            String availability = scanner3.nextLine();
            newCar.setAvailability(Integer.valueOf(availability));

            carController.editCar(newCar);
        } catch (InputMismatchException e) {
            System.out.print(e.getMessage());
        }
    }

    private void showCar() throws SQLException{
        List<Car> cars = carController.getAllCars();
        System.out.println("List of all cars : ");
        cars.forEach(car -> System.out.println(car.toString()));
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
                    showCar();
                    break;
                case 2:
                    saveCar();
                    break;
                case 3:
                    deleteCar();
                    break;
                case 4:
                    updateCar();
                    break;
                case 5:
                    getByIdCar();
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
