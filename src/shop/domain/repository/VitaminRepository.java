package shop.domain.repository;

import shop.domain.entity.Vitamin;
import shop.tool.VitaminBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class VitaminRepository {
    private static ArrayList<Vitamin> vitamins;
    private static File file;

    public VitaminRepository (String fileName) {
        file = new File(fileName);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(fileInputStream);
        this.vitamins = new ArrayList<Vitamin>(10);
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            String[] splitedData = line.split(", ");
            if (splitedData[0].equals("v")) {
                Vitamin newEntry =
                        new VitaminBuilder()
                                .withId()
                                .withName(splitedData[1])
                                .withPrice(Double.parseDouble(splitedData[2]))
                                .withDiscount(Double.parseDouble(splitedData[3]))
                                .withWeight(Double.parseDouble(splitedData[4]))
                                .withFlavour(splitedData[5])
                                .withForm(splitedData[5])
                                .withType(splitedData[7])
                                .withProducer(splitedData[8])
                                .build();
                vitamins.add(newEntry);
            }
        }
    }

    public ArrayList<Vitamin> getVitamins() {
        return vitamins;
    }

    public ArrayList<Vitamin> getVitaminsByForm (String form) {
        ArrayList<Vitamin> vitaminsByForm = new ArrayList<Vitamin>();
        for (int i = 0; i < vitamins.size(); i++) {
            if (vitamins.get(i).getForm().equals(form))
                vitaminsByForm.add(vitamins.get(i));
        }
        return vitaminsByForm;
    }

    public ArrayList<Vitamin> getVitaminsByType (String type) {
        ArrayList<Vitamin> vitaminsByType = new ArrayList<Vitamin>();
        for (int i = 0; i < vitamins.size(); i++) {
            if (vitamins.get(i).getType().equals(type))
                vitaminsByType.add(vitamins.get(i));
        }
        return vitaminsByType;
    }

    public static Vitamin getVitaminById (int id) {
        for (int i = 0; i < vitamins.size(); i++) {
            if (vitamins.get(i).getId() == id)
                return vitamins.get(i);
        }
        return null;
    }

    public void listAllvitamins () {
        System.out.println("All available vitamins:\n");
        for (int i = 0; i < vitamins.size(); i++) {
            System.out.println("Vitamin id: " + vitamins.get(i).getId() + "\nVitamin producer: " + vitamins.get(i).getProducer() + "\nVitamin name: " + vitamins.get(i).getName() + "\nPrice: " + vitamins.get(i).getPrice() + " lei\nDiscount: " + vitamins.get(i).getDiscount() + "\nWeight: " + vitamins.get(i).getWeight() + " kg\nFlavour: " + vitamins.get(i).getFlavour() + "\nForm: " + vitamins.get(i).getForm() + "\nType: " + vitamins.get(i).getType());
            System.out.println("***********************");
        }
    }
}
