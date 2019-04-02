package shop.domain.entity;

import java.util.ArrayList;

public class Producer {
    private int id;
    private String name;
    private long CUI;
    private static int currentProducer = 0;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getCUI() {
        return CUI;
    }

    public static int getCurrentProducer() {
        return currentProducer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCUI(long CUI) {
        this.CUI = CUI;
    }

    public static void increaseCurrentProducer() {
        Producer.currentProducer++;
    }

    public static void show (ArrayList<Producer> producers) {
        if (producers.size() == 0) {
            System.out.println("Nothing found!");
            return;
        }
        for (int i = 0; i < producers.size(); i++) {
            System.out.println("Producer id: " + producers.get(i).getId() + "\nProducer name: " + producers.get(i).getName() + "\nProducer CUI: " + producers.get(i).getCUI());
        }
    }
}
