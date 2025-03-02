package hiber.service;

import hiber.model.Car;

public interface CarService {

    Car getCarByModelAndSeries(String model, int series);
}
