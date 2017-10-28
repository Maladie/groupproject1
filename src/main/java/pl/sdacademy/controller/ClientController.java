package pl.sdacademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import pl.sdacademy.model.Address;
import pl.sdacademy.model.Car;
import pl.sdacademy.model.Client;
import pl.sdacademy.model.ClientDto;
import pl.sdacademy.model.test.Stocks;
import pl.sdacademy.service.CarService;
import pl.sdacademy.service.ClientService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ClientController {

    private ClientService clientService;

    private CarService carService;

    @Autowired
    public ClientController(ClientService clientService, CarService carService) {
        this.clientService = clientService;
        this.carService = carService;
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

    @RequestMapping(value = "/mockbase", method = RequestMethod.POST)
    public void initializeDatabase(){
        List<Client> clients = new ArrayList<>();
        Client client1 = new Client("Antek", "Hassan", new Address("Moniuszki", 7, 69, "43-987", "Katowice"), 34, new ArrayList<>());
        clients.add(client1);
        Client client2 = new Client("Antek1", "Hassan", new Address("Moniuszki", 7, 69, "43-987", "Katowice"), 34, new ArrayList<>());
        clients.add(client2);
        Client client3 = new Client("Antek2", "Hassan", new Address("Moniuszki", 7, 69, "43-987", "Katowice"), 34, new ArrayList<>());
        clients.add(client3);
        Client client4 = new Client("Antek3", "Hassan", new Address("Moniuszki", 7, 69, "43-987", "Katowice"), 34, new ArrayList<>());
        clients.add(client4);
        Client client5 = new Client("Antek4", "Hassan", new Address("Moniuszki", 7, 69, "43-987", "Katowice"), 34, new ArrayList<>());
        clients.add(client5);
        Client client6 = new Client("Antek5", "Hassan", new Address("Moniuszki", 7, 69, "43-987", "Katowice"), 34, new ArrayList<>());
        clients.add(client6);
        Client client7 = new Client("Antek6", "Hassan", new Address("Moniuszki", 7, 69, "43-987", "Katowice"), 34, new ArrayList<>());
        clients.add(client7);
        Client client8 = new Client("Antek7", "Hassan", new Address("Moniuszki", 7, 69, "43-987", "Katowice"), 34, new ArrayList<>());
        clients.add(client8);
        Client client9 = new Client("Antek8", "Hassan", new Address("Moniuszki", 7, 69, "43-987", "Katowice"), 34, new ArrayList<>());
        clients.add(client9);
        Client client10 = new Client("Antek9", "Hassan", new Address("Moniuszki", 7, 69, "43-987", "Katowice"), 34, new ArrayList<>());
        clients.add(client10);
        Client client11 = new Client("Antek10", "Hassan", new Address("Moniuszki", 7, 69, "43-987", "Katowice"), 34, new ArrayList<>());
        clients.add(client11);
        Client client12 = new Client("Antek11", "Hassan", new Address("Moniuszki", 7, 69, "43-987", "Katowice"), 34, new ArrayList<>());
        clients.add(client12);
        clientService.saveClientList(clients);
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

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity<Stocks> test(){
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "http://webtask.future-processing.com:8068/stocks";
        Stocks test = restTemplate
                .getForObject(fooResourceUrl, Stocks.class);
        System.out.println(test);
        return new ResponseEntity<Stocks>(test, HttpStatus.CREATED);
    }
}
