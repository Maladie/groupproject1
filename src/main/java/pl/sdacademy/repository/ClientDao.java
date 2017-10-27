package pl.sdacademy.repository;

import org.apache.catalina.startup.ClassLoaderFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.sdacademy.model.Client;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@javax.transaction.Transactional
public class ClientDao {

    @PersistenceContext
    EntityManager entityManager;

    public void saveClient(Client client) {
        entityManager.persist(client);
    }
}
