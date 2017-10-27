package pl.sdacademy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sdacademy.model.Car;
import pl.sdacademy.model.Client;
import pl.sdacademy.model.ClientDto;
import pl.sdacademy.repository.ClientRepository;

import java.util.ArrayList;
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

    public void updateClient(Client client){
        Client clientToUpdate = clientRepository.findById(client.getId());
        clientToUpdate.setName(client.getName());
        clientToUpdate.setSurname(client.getSurname());
        clientToUpdate.setAddress(client.getAddress());
        clientToUpdate.setAge(client.getAge());
        clientRepository.save(clientToUpdate);
    }

    public List<ClientDto> findByAll (){
        List<Client> clients = clientRepository.findAll();
        return convertToDtoList(clients);
    }

    public List<ClientDto> findBySurname (String surname){
        List<Client> clients = clientRepository.findBySurname(surname);
        return convertToDtoList(clients);
    }

    public List<ClientDto> findByCity (String city){
        List<Client> clients = clientRepository.findByAddressCity(city);
        return convertToDtoList(clients);
    }

    public void addCarToClient(Car car, int clientId){
        Client client = clientRepository.findById(clientId);
        client.addCarToList(car);
    }




    private List<ClientDto> convertToDtoList(List<Client> clients){
        List<ClientDto> clientDtos = new ArrayList<>();
        clientRepository.findAll().forEach(client -> {
            ClientDto clientDto=  client.convertToDto();
            clientDtos.add(clientDto);});
        return clientDtos;
    }
}
