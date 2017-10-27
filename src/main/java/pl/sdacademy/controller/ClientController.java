package pl.sdacademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.sdacademy.model.Client;
import pl.sdacademy.repository.ClientDao;
import pl.sdacademy.repository.ClientRepository;
import pl.sdacademy.service.ClientService;

import java.util.List;

@RestController
public class ClientController {

    private ClientService clientService;
    private ClientDao clientDao;
    private ClientRepository clientRepository;


    @Autowired
    public ClientController(ClientService clientService, ClientDao clientDao, ClientRepository clientRepository) {
        this.clientService = clientService;
        this.clientDao = clientDao;
        this.clientRepository = clientRepository;
    }


    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public List<Client> findByAll (){
        return clientRepository.findAll();
    }

    @RequestMapping(value = "/findSurname",method = RequestMethod.GET)
    public List<Client> findBySurname (@RequestParam(value = "surname") String surname){
        return clientRepository.findBySurname(surname);

    }

    @RequestMapping(value = "/findCity",method = RequestMethod.GET)
    public List<Client> findByCity (@RequestParam(value = "city") String city){
       return clientRepository.findByAddressCity(city);

    }


}
