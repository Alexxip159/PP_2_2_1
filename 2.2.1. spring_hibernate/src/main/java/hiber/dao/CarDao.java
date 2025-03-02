package hiber.dao;

import hiber.model.Car;

public interface CarDao {

    Car getCarByModelAndSeries(String model, int series);
}
