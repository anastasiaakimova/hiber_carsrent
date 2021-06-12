package org.example.controller;

import org.example.entity.Car;
import org.example.repository.GenericRepo;
import org.example.repository.impl.CarRepoImpl;

import java.sql.SQLException;
import java.util.List;

public class CarController {
    private GenericRepo carRepo = new CarRepoImpl();

    public Car getCarById(Long id) throws SQLException {
        return (Car) carRepo.getById(id);
    }

    public Car editCar(Car car) throws SQLException {
        return (Car) carRepo.update(car);
    }

    public List<Car> getAllCars() throws SQLException {
        return carRepo.getAll();
    }

    public void saveCar(Car car) throws SQLException {
        carRepo.add(car);
    }

    public void deleteCar(Long id) throws SQLException {
        carRepo.remove(id);
    }
}
