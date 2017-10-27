package pl.sdacademy.model;


import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@javax.persistence.Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min = 2)
    String name;

    @NotNull
    String surname;

    @Embedded
    Address address;

    @Min(value = 1)
    @Max(value = 100)
    Integer age;

    @OneToMany
    List<Car> interestedCarList;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Address getAddress() {
        return address;
    }

    public Integer getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Client() {
    }

    public Client(String name, String surname, Address address, Integer age, List<Car> interestedCarList) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.age = age;
        this.interestedCarList = interestedCarList;
    }
}
