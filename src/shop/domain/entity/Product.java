package shop.domain.entity;

public abstract class Product {
    private int id;
    private double price;
    private String name;
    private double discount;
    private double weight;
    private String flavour;

    public Product(int id, double price, String name, double discount, double weight, String flavour) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.discount = discount;
        this.weight = weight;
        this.flavour = flavour;
    }
}
