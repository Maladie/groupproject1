package pl.sdacademy.repository;

import pl.sdacademy.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    List<Client> findAll();
    List<Client> findBySurname(String surname);
    List<Client> findByAddressCity(String city);
}
