package shop.domain.entity;

public class Protein extends Product {
    private double concentration;
    private String type;
    private static int currentProtein = 0;

    public Protein(double price, String name, double discount, double weight, String flavour, double concentration, String type) {
        super(++currentProtein, price, name, discount, weight, flavour);
        this.concentration = concentration;
        this.type = type;
    }
}
