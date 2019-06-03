package shop.domain.entity;

public abstract class Product {
    private int id;
    private double price;
    private String name;
    private double discount;
    private double weight;
    private String flavour;
    private String producer;

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

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public static String displayProducts(Product[] products) {
        String  sBProducts = "";
        for (int j = 0; j < products.length; j++) {
            sBProducts += "Producer: " + products[j].getProducer() + "\nProduct name: " + products[j].getName() + "\nProduct flavour: " + products[j].getFlavour() + "\nWeight: " + products[j].getWeight() + " kg\nDiscount: " + products[j].getDiscount() * 100 + " %\nPrice: " + products[j].getPrice() + " lei\nPrice after discount: " + (products[j].getPrice() - products[j].getPrice() * products[j].getDiscount()) + " lei\n";
            sBProducts += "*****************************\n";
        }
        return sBProducts;
    }

    @Override
    public String toString() {
        return getId() + ", ";
    }
}
