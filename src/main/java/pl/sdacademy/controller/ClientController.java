package pl.sdacademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import pl.sdacademy.model.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.sdacademy.model.Car;
import pl.sdacademy.repository.CarRepository;
import pl.sdacademy.repository.ClientRepository;
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
        List<Car> cars = new ArrayList<Car>();
        Car car1 = new Car("audi", "a3", 2000, "Benzyna");
        cars.add(car1);
        Car car2 = new Car("vw", "passat", 2200, "Benzyna");
        cars.add(car2);
        Car car3 = new Car("bmw", "serie3", 2500, "Diesel");
        cars.add(car3);
        Car car4 = new Car("mercedes", "A class", 1900, "Gas+Benzyna");
        cars.add(car4);

        Client client1 = new Client("Antek", "Hassan", new Address("Moniuszki", 7, 69, "43-987", "Katowice"), 34, cars);
        clients.add(client1);
        Client client2 = new Client("Antek1", "Hassan", new Address("Moniuszki", 7, 69, "43-987", "Katowice"), 34, cars);
        clients.add(client2);
        Client client3 = new Client("Antek2", "Hassan", new Address("Moniuszki", 7, 69, "43-987", "Katowice"), 34, cars);
        clients.add(client3);
        Client client4 = new Client("Antek3", "Hassan", new Address("Moniuszki", 7, 69, "43-987", "Katowice"), 34, cars);
        clients.add(client4);
        Client client5 = new Client("Antek4", "Hassan", new Address("Moniuszki", 7, 69, "43-987", "Katowice"), 34, cars);
        clients.add(client5);
        Client client6 = new Client("Antek5", "Hassan", new Address("Moniuszki", 7, 69, "43-987", "Katowice"), 34, cars);
        clients.add(client6);
        Client client7 = new Client("Antek6", "Hassan", new Address("Moniuszki", 7, 69, "43-987", "Katowice"), 34, cars);
        clients.add(client7);
        Client client8 = new Client("Antek7", "Hassan", new Address("Moniuszki", 7, 69, "43-987", "Katowice"), 34, cars);
        clients.add(client8);
        Client client9 = new Client("Antek8", "Hassan", new Address("Moniuszki", 7, 69, "43-987", "Katowice"), 34, cars);
        clients.add(client9);
        Client client10 = new Client("Antek9", "Hassan", new Address("Moniuszki", 7, 69, "43-987", "Katowice"), 34, cars);
        clients.add(client10);
        Client client11 = new Client("Antek10", "Hassan", new Address("Moniuszki", 7, 69, "43-987", "Katowice"), 34, cars);
        clients.add(client11);
        Client client12 = new Client("Antek11", "Hassan", new Address("Moniuszki", 7, 69, "43-987", "Katowice"), 34, cars);
        clients.add(client12);
        carService.saveCarsList(cars);
        clientService.saveClientList(clients);
    }
    @RequestMapping(value = "/addCar",method = RequestMethod.POST)
    public void addCar(@RequestBody Car car, @RequestParam(value = "id") Integer clientId){
       clientService.addCarToClient(car,clientId);
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Client> createClient(@RequestBody @Valid Client client){
        clientService.persistClient(client);
        return new ResponseEntity<>(client, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<Client> updateClient(@Valid  @RequestBody Client client){
        clientService.updateClient(client);
        return new ResponseEntity<Client>(client, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/addCar", method = RequestMethod.POST)
    public ResponseEntity<Car> addCar(@Valid @RequestBody AddCarRequest carRequest){
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "DOWYSLANIA/getCar/" + carRequest.getCarId();
        Car car = restTemplate
                .getForObject(fooResourceUrl, Car.class);

        if (!car.isReserved()) {
            carService.persistCar(car);

            clientService.addCarToClient(car, carRequest.getClientId());

            String fooResourceUrl2 = "REZERWOWANY SAMOCHOD" + carRequest.getCarId();
        }

        return restTemplate.getForEntity(fooResourceUrl, Car.class);




    }


  }
