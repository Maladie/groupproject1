package pl.sdacademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.sdacademy.model.Car;
import pl.sdacademy.model.Client;
import pl.sdacademy.service.ClientService;

import java.util.List;

@RestController
public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public List<Client> findByAll (){
       return clientService.findByAll();
    }

    @RequestMapping(value = "/findSurname",method = RequestMethod.GET)
    public List<Client> findBySurname (@RequestParam(value = "surname") String surname){
        return clientService.findBySurname(surname);
    }

    @RequestMapping(value = "/findCity",method = RequestMethod.GET)
    public List<Client> findByCity (@RequestParam(value = "city") String city){
        return clientService.findByCity(city);
    }

    @RequestMapping(value = "/addCar",method = RequestMethod.POST)
    public void addCar(@RequestBody Car car, @RequestParam(value = "id") Integer clientId){
       clientService.addCarToClient(car,clientId);
    }



}
