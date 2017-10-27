package pl.sdacademy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sdacademy.model.Client;
import pl.sdacademy.repository.ClientDao;
import pl.sdacademy.repository.ClientRepository;

import java.util.List;

@Service
public class ClientService {

    private ClientDao clientDao;

    private ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientDao clientDao, ClientRepository clientRepository) {
        this.clientDao = clientDao;
        this.clientRepository = clientRepository;
    }

    public void persistClient(Client client){
        clientDao.saveClient(client);
    }

    public void updateClient(Client client){
        clientDao.updateClient(client);
    }

    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    public List<Client> getByAddress(String city){
        return clientRepository.findByAddressCity(city);
    }

    public List<Client> getBySurname(String surname){
        return clientRepository.findBySurname(surname);
    }


}
