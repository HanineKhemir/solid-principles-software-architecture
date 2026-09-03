package com.directi.training.srp.exercise_refactored;

import java.util.List;

/**
 * Business rule only: decides which car is "best".
 * Changes here are driven by the ranking policy. Today it is the
 * alphabetically last model name; swapping in price or year touches
 * this class and nothing else.
 */
public class CarRanker
{
    public Car best(List<Car> cars)
    {
        Car bestCar = null;
        for (Car car : cars) {
            if (bestCar == null || car.getModel().compareTo(bestCar.getModel()) > 0) {
                bestCar = car;
            }
        }
        return bestCar;
    }
}
