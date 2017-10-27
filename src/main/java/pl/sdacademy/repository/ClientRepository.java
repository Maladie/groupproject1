package pl.sdacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sdacademy.model.Car;
import pl.sdacademy.model.Client;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    List<Client> findAll();
    List<Client> findBySurname(String surname);
    List<Client> findByAddressCity(String city);
}
