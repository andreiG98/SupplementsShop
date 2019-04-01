package shop.domain.entity;

import shop.tool.ProducerBuilder;

public abstract class Product {
    private int id;
    private double price;
    private String name;
    private double discount;
    private double weight;
    private String flavour;
    private Producer producer;

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public double getDiscount() {
        return discount;
    }

    public double getWeight() {
        return weight;
    }

    public String getFlavour() {
        return flavour;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer =
                new ProducerBuilder()
                        .withId()
                        .withName(producer.getName())
                        .withCUI(producer.getCUI())
                        .build();
    }
}
