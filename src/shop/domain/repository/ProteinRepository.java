package shop.domain.repository;

import shop.domain.entity.Product;
import shop.domain.entity.Protein;
import shop.tool.ProteinBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class ProteinRepository {

    private static Set<Protein> proteins;
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
        this.proteins = new TreeSet<>(Comparator.comparing(Product::getName));
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
        Iterator<Protein> it = proteins.iterator();
        Protein current;
        while(it.hasNext() ) {
            current = it.next();
            if (current.getId() == id) {
                return current;
            }
        }
        return null;
    }

    public ArrayList<Protein> getProteinByConcentration (double concentration) {
        ArrayList<Protein> proteinsByConcentration = new ArrayList<Protein>();
        Iterator<Protein> it = proteins.iterator();
        Protein current;
        while(it.hasNext() ) {
            current = it.next();
            if (current.getConcentration() == concentration) {
                proteinsByConcentration.add(current);
            }
        }
        return proteinsByConcentration;
    }

    public ArrayList<Protein> getProteinByType (String type) {
        ArrayList<Protein> proteinsByType = new ArrayList<Protein>();
        Iterator<Protein> it = proteins.iterator();
        Protein current;
        while(it.hasNext() ) {
            current = it.next();
            if (current.getType().equals(type)) {
                proteinsByType.add(current);
            }
        }
        return proteinsByType;
    }

    public void listAllProteins () {
        System.out.println("All available proteins:\n");
        Iterator<Protein> it = proteins.iterator();
        Protein current;
        while(it.hasNext() ) {
            current = it.next();
            System.out.println("Protein id: " + current.getId() + "\nProtein producer: " + current.getProducer() + "\nProtein name: " + current.getName() + "\nPrice: " + current.getPrice() + " lei\nDiscount " + current.getDiscount() + "\nWeight: " + current.getWeight() + " kg\nFlavour: " + current.getFlavour() + "\nConcentration: " + current.getConcentration() + "\nType: " + current.getType());
            System.out.println("***********************");
        }
    }
}
