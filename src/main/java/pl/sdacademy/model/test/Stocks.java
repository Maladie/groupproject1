package pl.sdacademy.model.test;

import java.util.List;

public class Stocks {
//    private LocalDateTime publicationDate;
    private List<Stock> items;

    public Stocks() {
    }

//    public LocalDateTime getPublicationDate() {
//        return publicationDate;
//    }
//
//    public void setPublicationDate(LocalDateTime publicationDate) {
//        this.publicationDate = publicationDate;
//    }

    public List<Stock> getItems() {
        return items;
    }

    public void setItems(List<Stock> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Stocks{" +
                "publicationDate=" +
                ", items=" + items +
                '}';
    }
}
