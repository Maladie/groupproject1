package pl.sdacademy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sdacademy.model.Client;
import pl.sdacademy.repository.ClientRepository;

import java.util.List;

@Service
public class ClientService {


    private ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void persistClient(Client client){
       clientRepository.save(client);
    }

    public List<Client> findByAll (){
        return clientRepository.findAll();
    }

    public List<Client> findBySurname (String surname){
        return clientRepository.findBySurname(surname);

    }

    public List<Client> findByCity (String city){
        return clientRepository.findByAddressCity(city);

    }




}
