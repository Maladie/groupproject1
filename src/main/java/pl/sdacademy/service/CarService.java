package pl.sdacademy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sdacademy.model.Car;
import pl.sdacademy.repository.CarRepository;

import java.util.List;

@Service
public class CarService {

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    private CarRepository carRepository;

    public void saveCarsList(List<Car> carList){
        carRepository.save(carList);
    }

}
