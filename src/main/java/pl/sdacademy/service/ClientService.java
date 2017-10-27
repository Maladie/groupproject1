package pl.sdacademy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sdacademy.model.Client;
import pl.sdacademy.repository.ClientDao;
import pl.sdacademy.repository.ClientRepository;

import java.util.List;

@Service
public class ClientService {


    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
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
