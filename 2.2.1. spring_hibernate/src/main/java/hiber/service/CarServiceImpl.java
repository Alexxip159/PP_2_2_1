package hiber.service;

import hiber.dao.CarDao;
import hiber.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarDao carDao;

    @Override
    @Transactional(readOnly = true)
    public Car getCarByModelAndSeries(String model, int series) {
        return carDao.getCarByModelAndSeries(model, series);
    }
}
