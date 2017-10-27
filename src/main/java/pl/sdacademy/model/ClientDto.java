package pl.sdacademy.model;

import java.util.List;

public class ClientDto {

    private String name;
    private String surname;
    private Address address;
    private Integer age;
    private List<Car> bookedCars;

    public ClientDto(String name, String surname, Address address, Integer age, List<Car> bookedCars) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.age = age;
        this.bookedCars = bookedCars;
    }

    private ClientDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Car> getBookedCars() {
        return bookedCars;
    }

    public void setBookedCars(List<Car> bookedCars) {
        this.bookedCars = bookedCars;
    }

    public static class ClientDtoBuilder {

        private ClientDto clientDto;

        public ClientDtoBuilder() {
            this.clientDto = new ClientDto();
        }

        public ClientDtoBuilder addName(String name){
            clientDto.setName(name);
            return this;
        }

        public ClientDtoBuilder addSurname(String surname){
            clientDto.setSurname(surname);
            return this;
        }

        public ClientDtoBuilder addAddress(Address address){
            clientDto.setAddress(address);
            return this;
        }

        public ClientDtoBuilder addAge (Integer age){
            clientDto.setAge(age);
            return this;
        }

        public ClientDtoBuilder addBookedCars(List<Car> bookedCars){
            clientDto.setBookedCars(bookedCars);
            return this;
        }

        public ClientDto build(){
            return clientDto;
        }


    }
}
