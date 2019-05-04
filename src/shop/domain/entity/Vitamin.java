package shop.domain.entity;

import java.util.ArrayList;

public class Vitamin extends Product {
    private String type;
    private String form;
    private static int currentVitamin = 0;

    public String getType() {
        return type;
    }

    public String getForm() {
        return form;
    }

    public static int getCurrentVitamin() {
        return currentVitamin;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public static void increaseCurrentVitamin() {
        Vitamin.currentVitamin++;
    }

    public static void show (ArrayList<Vitamin> vitamins) {
        if (vitamins.size() == 0) {
            System.out.println("Nothing found!");
            return;
        }
        for (int i = 0; i < vitamins.size(); i++) {
            System.out.println("Vitamin id: " + vitamins.get(i).getId() + "\nVitamin producer: " + vitamins.get(i).getProducer() + "\nVitamin name: " + vitamins.get(i).getName() + "\nPrice: " + vitamins.get(i).getPrice() + " lei\nDiscount: " + vitamins.get(i).getDiscount() + "\nWeight: " + vitamins.get(i).getWeight() + " kg\nFlavour: " + vitamins.get(i).getFlavour() + "\nForm: " + vitamins.get(i).getForm() + "\nType: " + vitamins.get(i).getType());
            System.out.println("***************************");
        }
    }

    @Override
    public String toString() {
        return super.toString() + "v";
    }
}
