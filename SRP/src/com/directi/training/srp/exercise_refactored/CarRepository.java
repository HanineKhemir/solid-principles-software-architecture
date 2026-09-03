package com.directi.training.srp.exercise_refactored;

import java.util.Arrays;
import java.util.List;

/**
 * Data access only: knows where the cars are stored and how to fetch them.
 * Changes here are driven by the storage (in-memory list today, a real
 * database tomorrow), never by how cars are displayed or ranked.
 */
public class CarRepository
{
    private final List<Car> _cars = Arrays.asList(
        new Car("1", "Golf III", "Volkswagen"),
        new Car("2", "Multipla", "Fiat"),
        new Car("3", "Megane", "Renault"));

    public List<Car> findAll()
    {
        return _cars;
    }

    public Car findById(final String carId)
    {
        for (Car car : _cars) {
            if (car.getId().equals(carId)) {
                return car;
            }
        }
        return null;
    }
}
