package shop.domain.repository;

import shop.domain.entity.Product;
import shop.domain.entity.Vitamin;
import shop.tool.VitaminBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class VitaminRepository {

    private static Set<Vitamin> vitamins;
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
        this.vitamins = new TreeSet<>(Comparator.comparing(Product::getName));
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

    public ArrayList getVitamins() {
        ArrayList<Vitamin> allVitamins = new ArrayList<Vitamin>();
        Iterator<Vitamin> it = vitamins.iterator();
        Vitamin current;
        while(it.hasNext() ) {
            current = it.next();
            allVitamins.add(current);
        }
        return allVitamins;
    }

    public ArrayList<Vitamin> getVitaminsByForm (String form) {
        ArrayList<Vitamin> vitaminsByForm = new ArrayList<Vitamin>();
        Iterator<Vitamin> it = vitamins.iterator();
        Vitamin current;
        while(it.hasNext() ) {
            current = it.next();
            if (current.getForm().equals(form)) {
                vitaminsByForm.add(current);
            }
        }
        return vitaminsByForm;
    }

    public ArrayList<Vitamin> getVitaminsByType (String type) {
        ArrayList<Vitamin> vitaminsByType = new ArrayList<Vitamin>();
        Iterator<Vitamin> it = vitamins.iterator();
        Vitamin current;
        while(it.hasNext() ) {
            current = it.next();
            if (current.getForm().equals(type)) {
                vitaminsByType.add(current);
            }
        }
        return vitaminsByType;
    }

    public static Vitamin getVitaminById (int id) {
        Iterator<Vitamin> it = vitamins.iterator();
        Vitamin current;
        while(it.hasNext() ) {
            current = it.next();
            if (current.getId() == id) {
                return current;
            }
        }
        return null;
    }

    public void listAllvitamins () {
        System.out.println("All available vitamins:\n");
        Iterator<Vitamin> it = vitamins.iterator();
        Vitamin current;
        while(it.hasNext() ) {
            current = it.next();
            System.out.println("Vitamin id: " + current.getId() + "\nVitamin producer: " + current.getProducer() + "\nVitamin name: " + current.getName() + "\nPrice: " + current.getPrice() + " lei\nDiscount: " + current.getDiscount() + "\nWeight: " + current.getWeight() + " kg\nFlavour: " + current.getFlavour() + "\nForm: " + current.getForm() + "\nType: " + current.getType());
            System.out.println("***********************");
        }
    }
}
