package pl.sdacademy.repository;

import org.springframework.stereotype.Repository;
import pl.sdacademy.model.Client;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@javax.transaction.Transactional
public class ClientDao {

    @PersistenceContext
    EntityManager entityManager;

    public void saveClient(Client client) {
        entityManager.persist(client);
    }

    public void updateClient(Client client) {
        entityManager.merge(client);
    }
}
