package shop.domain.entity;

public class Vitamin extends Product {
    private String type;
    private String form;
    private static int currentVitamin = 0;

    public Vitamin(double price, String name, double discount, double weight, String flavour, String type, String form) {
       // super(++currentVitamin, price, name, discount, weight, flavour);
        this.type = type;
        this.form = form;
    }

    public String getType() {
        return type;
    }

    public String getForm() {
        return form;
    }
}
