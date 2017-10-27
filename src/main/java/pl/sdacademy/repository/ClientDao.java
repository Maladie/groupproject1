package pl.sdacademy.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.sdacademy.model.Client;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class ClientDao {

    @PersistenceContext
    EntityManager entityManager;

    public void saveClient(Client client) {
        entityManager.persist(client);
    }
}
