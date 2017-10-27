package pl.sdacademy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sdacademy.repository.ClientDao;
import pl.sdacademy.repository.ClientRepository;

@Service
public class ClientService {

    private ClientDao clientDao;

    private ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientDao clientDao, ClientRepository clientRepository) {
        this.clientDao = clientDao;
        this.clientRepository = clientRepository;
    }
}
