package com.directi.training.srp.exercise_refactored;

import java.util.List;

/**
 * Presentation only: turns cars into text for display.
 * Changes here are driven by UI requirements (separator, order of
 * brand/model, localisation), nothing else.
 */
public class CarFormatter
{
    public String formatNames(List<Car> cars)
    {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(car.getBrand()).append(" ").append(car.getModel());
        }
        return sb.toString();
    }
}
