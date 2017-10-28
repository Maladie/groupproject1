package pl.sdacademy.model.test;

import java.io.Serializable;

public class Stock implements Serializable{
    private String name;
    private String code;
    private long unit;
    private double price;

    public Stock() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getUnit() {
        return unit;
    }

    public void setUnit(long unit) {
        this.unit = unit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", unit=" + unit +
                ", price=" + price +
                '}';
    }
}
