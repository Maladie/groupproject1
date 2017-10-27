package pl.sdacademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.*;
import pl.sdacademy.model.Car;
import pl.sdacademy.model.Client;
import pl.sdacademy.model.ClientDto;
import pl.sdacademy.service.ClientService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public List<ClientDto> findByAll (){
       return clientService.findByAll();
    }

    @RequestMapping(value = "/findSurname",method = RequestMethod.GET)
    public List<ClientDto> findBySurname (@RequestParam(value = "surname") String surname){
        return clientService.findBySurname(surname);
    }

    @RequestMapping(value = "/findCity",method = RequestMethod.GET)
    public List<ClientDto> findByCity (@RequestParam(value = "city") String city){
        return clientService.findByCity(city);
    }

    @RequestMapping(value = "/addCar",method = RequestMethod.POST)
    public void addCar(@RequestBody Car car, @RequestParam(value = "id") Integer clientId){
       clientService.addCarToClient(car,clientId);
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Client> createClient(@RequestBody @Valid Client client){
        clientService.persistClient(client);
        return new ResponseEntity<Client>(client, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<Client> updateClient(@RequestBody @Valid Client client){
        clientService.updateClient(client);
        return new ResponseEntity<Client>(client, HttpStatus.CREATED);
    }
}
