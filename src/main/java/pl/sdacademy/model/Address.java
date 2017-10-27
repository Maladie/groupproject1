package pl.sdacademy.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

    private String street;
    @Column(name="building_number")
    private Integer buildingNumber;
    @Column(name="apartment_number")
    private Integer apartmentNumber;
    @Column(name="zip_code")
    private String zipCode;
    private String city;

    {
        apartmentNumber = null;
    }

    public Address(String street, Integer buildingNumber, Integer apartmentNumber, String zipCode, String city) {
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.apartmentNumber = apartmentNumber;
        this.zipCode = zipCode;
        this.city = city;
    }

    public Address(String street, int buildingNumber, String zipCode, String city) {
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.zipCode = zipCode;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(Integer buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public Integer getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(Integer apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(street + " " + buildingNumber + " ");
        if(apartmentNumber!=null){
            sb.append("/" + apartmentNumber);
        }
        sb.append(" "  + zipCode + " " + city);
        return sb.toString();
    }
}
