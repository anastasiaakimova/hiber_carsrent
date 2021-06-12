package org.example.view;

import org.example.controller.CarController;
import org.example.entity.Car;
import org.example.entity.Client;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CarView {
    private CarController carController = new CarController();

    private void getByIdCar() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id машины :");
        Long id = Long.parseLong(scanner.next());
        try {
            if (carController.getCarById(id) != null){
                System.out.println(carController.getCarById(id).toString());}

            else {
                System.out.println("Такой машины не существует");
            }

        } catch (NullPointerException | SQLException e) {
            System.out.println("Это не число");
            System.out.println("Попробуйте еще раз, пожалуйста");
            getByIdCar();
        }
    }

    private void updateCar() throws SQLException{
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите id магины которую хотите обновить :");
            Long id = Long.parseLong(scanner.next());

            Car newCar;
            newCar =carController.getCarById(id);

            System.out.println("Введите модель :");
            String model = scanner.nextLine();
            newCar.setModel(model);

            System.out.println("Введите цвет :");
            String color = scanner.nextLine();
            newCar.setColor(color);

            System.out.println("Введите цену :");
            String price = scanner.nextLine();
            newCar.setPrice(Integer.valueOf(price));

            System.out.println("Введите мощность :");
            String availability = scanner.nextLine();
            newCar.setAvailability(Integer.valueOf(availability));

            carController.editCar(newCar);
        } catch (InputMismatchException e) {
            System.out.print(e.getMessage());
        }
    }

    private void deleteCar() throws SQLException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id для удаления машины : ");
        Long id = Long.parseLong(scanner.next());
        carController.deleteCar(id);
    }

    private void saveCar() throws SQLException{
        try {
            Scanner scanner = new Scanner(System.in);
            Car newCar = new Car();

            System.out.println("Введите модель :");
            String model = scanner.nextLine();
            newCar.setModel(model);

            System.out.println("Введите цвет :");
            String color = scanner.nextLine();
            newCar.setColor(color);

            System.out.println("Введите цену :");
            String price = scanner.nextLine();
            newCar.setPrice(Integer.valueOf(price));

            System.out.println("Введите мощность :");
            String availability = scanner.nextLine();
            newCar.setAvailability(Integer.valueOf(availability));

            carController.editCar(newCar);
        } catch (InputMismatchException e) {
            System.out.print(e.getMessage());
        }
    }

    private void showCar() throws SQLException{
        List<Car> cars = carController.getAllCars();
        System.out.println("Список всех машин : ");
        cars.forEach(car -> System.out.println(car.toString()));
    }

    public void run() throws SQLException {
        boolean go = true;
        while (go) {
            System.out.println("\n Выберите опцию :");
            System.out.println(" Введите число : ");
            System.out.println(" 1. Показать список машин");
            System.out.println(" 2. Добавить машину");
            System.out.println(" 3. Удалить машину ");
            System.out.println(" 4. Обновить информацию о машине  ");
            System.out.println(" 5. Найти машину по id ");
            System.out.println(" 6. Выход ");
            Scanner scanner = new Scanner(System.in);
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
                    System.out.println("Не верное число");
                    System.out.println("Выберите число от 1 до 6!");
            }
        }
    }
}
