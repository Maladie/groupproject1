package pl.sdacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sdacademy.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
}
