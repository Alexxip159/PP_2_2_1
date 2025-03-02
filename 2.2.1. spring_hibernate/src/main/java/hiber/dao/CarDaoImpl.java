package hiber.dao;

import hiber.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;

@Repository
public class CarDaoImpl implements CarDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Car getCarByModelAndSeries(String model, int series) {
        TypedQuery<Car> query = sessionFactory.getCurrentSession()
                .createQuery("from Car where model = :model and series = :series");
        query.setParameter("model", model);
        query.setParameter("series", series);
        return query.getSingleResult();
    }
}
