package shop.domain.repository;

import shop.domain.entity.Protein;
import shop.tool.ProteinBuilder;
import shop.tool.TestData;

import java.util.ArrayList;

public class ProteinRepository {
    private Protein[] proteins;

    public ProteinRepository () {
        int length = TestData.getInstance().getProteinData().length;
        this.proteins = new Protein[length];
        for (int i = 0; i < length; i++) {
            String [] splitedData = TestData.getInstance().getProteinData()[i].split(";");
            this.proteins[i] =
                    new ProteinBuilder()
                            .withId()
                            .withName(splitedData[0])
                            .withPrice(Double.parseDouble(splitedData[1]))
                            .withDiscount(Double.parseDouble(splitedData[2]))
                            .withWeight(Double.parseDouble(splitedData[3]))
                            .withFlavour(splitedData[4])
                            .withConcentration(Double.parseDouble(splitedData[5]))
                            .withType(splitedData[6])
                            .withProducer(splitedData[7])
                            .build();

        }
    }

    public Protein getProteinById (int id) {
        for (int i = 0; i < proteins.length; i++) {
            if (proteins[i].getId() == id) {
                return proteins[i];
            }
        }
        return null;
    }

    public ArrayList<Protein> getProteinByConcentration (double concentration) {
        ArrayList<Protein> proteinsByConcentration = new ArrayList<Protein>();
        for (int i = 0; i < proteins.length; i++) {
            if (proteins[i].getConcentration() == concentration)
                proteinsByConcentration.add(proteins[i]);
        }
        return proteinsByConcentration;
    }

    public ArrayList<Protein> getProteinByType (String type) {
        ArrayList<Protein> proteinsByType = new ArrayList<Protein>();
        for (int i = 0; i < proteins.length; i++) {
            if (proteins[i].getType().equals(type))
                proteinsByType.add(proteins[i]);
        }
        return proteinsByType;
    }

    public void listAllProteins () {
        System.out.println("All available proteins:\n");
        for (int i = 0; i < proteins.length; i++) {
            System.out.println("Protein id: " + proteins[i].getId() + "\nProtein producer: " + proteins[i].getProducer() + "\nProtein name: " + proteins[i].getName() + "\nPrice: " + proteins[i].getPrice() + " lei\nDiscount " + proteins[i].getDiscount() + "\nWeight: " + proteins[i].getWeight() + " kg\nFlavour: " + proteins[i].getFlavour() + "\nConcentration: " + proteins[i].getConcentration() + "\nType: " + proteins[i].getType());
            System.out.println("***********************");
        }
    }
}
