package shop.domain.repository;

import shop.domain.entity.Protein;
import shop.tool.ProteinBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProteinRepository {
    private static ArrayList<Protein> proteins;
    private static File file;

    public ProteinRepository (String fileName) {
        file = new File(fileName);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(fileInputStream);
        this.proteins = new ArrayList<Protein>(10);
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            String[] splitedData = line.split(", ");
            if (splitedData[0].equals("p")) {
                Protein newEntry =
                        new ProteinBuilder()
                                .withId()
                                .withName(splitedData[1])
                                .withPrice(Double.parseDouble(splitedData[2]))
                                .withDiscount(Double.parseDouble(splitedData[3]))
                                .withWeight(Double.parseDouble(splitedData[4]))
                                .withFlavour(splitedData[5])
                                .withConcentration(Double.parseDouble(splitedData[6]))
                                .withType(splitedData[7])
                                .withProducer(splitedData[8])
                                .build();
                proteins.add(newEntry);   
            }
        }
    }

    public static Protein getProteinById (int id) {
        for (int i = 0; i < proteins.size(); i++) {
            if (proteins.get(i).getId() == id) {
                return proteins.get(i);
            }
        }
        return null;
    }

    public ArrayList<Protein> getProteinByConcentration (double concentration) {
        ArrayList<Protein> proteinsByConcentration = new ArrayList<Protein>();
        for (int i = 0; i < proteins.size(); i++) {
            if (proteins.get(i).getConcentration() == concentration)
                proteinsByConcentration.add(proteins.get(i));
        }
        return proteinsByConcentration;
    }

    public ArrayList<Protein> getProteinByType (String type) {
        ArrayList<Protein> proteinsByType = new ArrayList<Protein>();
        for (int i = 0; i < proteins.size(); i++) {
            if (proteins.get(i).getType().equals(type))
                proteinsByType.add(proteins.get(i));
        }
        return proteinsByType;
    }

    public void listAllProteins () {
        System.out.println("All available proteins:\n");
        for (int i = 0; i < proteins.size(); i++) {
            System.out.println("Protein id: " + proteins.get(i).getId() + "\nProtein producer: " + proteins.get(i).getProducer() + "\nProtein name: " + proteins.get(i).getName() + "\nPrice: " + proteins.get(i).getPrice() + " lei\nDiscount " + proteins.get(i).getDiscount() + "\nWeight: " + proteins.get(i).getWeight() + " kg\nFlavour: " + proteins.get(i).getFlavour() + "\nConcentration: " + proteins.get(i).getConcentration() + "\nType: " + proteins.get(i).getType());
            System.out.println("***********************");
        }
    }
}
