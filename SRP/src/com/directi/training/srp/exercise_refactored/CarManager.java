package com.directi.training.srp.exercise_refactored;

/**
 * Thin facade that keeps the original public API. It owns no logic of
 * its own: it only delegates to the class responsible for each concern.
 */
public class CarManager
{
    private final CarRepository _repository;
    private final CarFormatter _formatter;
    private final CarRanker _ranker;

    public CarManager()
    {
        this(new CarRepository(), new CarFormatter(), new CarRanker());
    }

    public CarManager(CarRepository repository, CarFormatter formatter, CarRanker ranker)
    {
        _repository = repository;
        _formatter = formatter;
        _ranker = ranker;
    }

    public Car getFromDb(final String carId)
    {
        return _repository.findById(carId);
    }

    public String getCarsNames()
    {
        return _formatter.formatNames(_repository.findAll());
    }

    public Car getBestCar()
    {
        return _ranker.best(_repository.findAll());
    }
}
