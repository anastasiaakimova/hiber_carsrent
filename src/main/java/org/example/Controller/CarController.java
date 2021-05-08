package org.example.Controller;

import org.example.entity.Car;
import org.example.repository.CarRepo;
import org.example.repository.impl.CarRepoImpl;

import java.sql.SQLException;
import java.util.List;

public class CarController {
    private CarRepo carRepo = new CarRepoImpl();

    public Car getCarById(Long id) throws SQLException {
        return carRepo.getById(id);
    }

    public Car editCar(Car car) throws SQLException {
        return carRepo.update(car);
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
