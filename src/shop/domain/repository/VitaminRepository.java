package shop.domain.repository;

import shop.domain.entity.Vitamin;
import shop.tool.TestData;
import shop.tool.VitaminBuilder;

import java.util.ArrayList;

public class VitaminRepository {
    private Vitamin[] vitamins;

    public VitaminRepository () {
        int length = TestData.getInstance().getVitaminData().length;
        this.vitamins = new Vitamin[length];
        for (int i = 0; i < length; i++) {
            String [] splitedData = TestData.getInstance().getVitaminData()[i].split(";");
            this.vitamins[i] =
                    new VitaminBuilder()
                            .withId()
                            .withName(splitedData[0])
                            .withPrice(Double.parseDouble(splitedData[1]))
                            .withDiscount(Double.parseDouble(splitedData[2]))
                            .withWeight(Double.parseDouble(splitedData[3]))
                            .withFlavour(splitedData[4])
                            .withForm(splitedData[5])
                            .withType(splitedData[6])
                            .withProducer(splitedData[7])
                            .build();

        }
    }

    public ArrayList<Vitamin> getVitaminsByForm (String form) {
        ArrayList<Vitamin> vitaminsByForm = new ArrayList<Vitamin>();
        for (int i = 0; i < vitamins.length; i++) {
            if (vitamins[i].getForm().equals(form))
                vitaminsByForm.add(vitamins[i]);
        }
        return vitaminsByForm;
    }

    public ArrayList<Vitamin> getVitaminsByType (String type) {
        ArrayList<Vitamin> vitaminsByType = new ArrayList<Vitamin>();
        for (int i = 0; i < vitamins.length; i++) {
            if (vitamins[i].getType().equals(type))
                vitaminsByType.add(vitamins[i]);
        }
        return vitaminsByType;
    }

    public Vitamin getVitaminById (int id) {
        for (int i = 0; i < vitamins.length; i++) {
            if (vitamins[i].getId() == id)
                return vitamins[i];
        }
        return null;
    }

    public void listAllvitamins () {
        System.out.println("All available vitamins:\n");
        for (int i = 0; i < vitamins.length; i++) {
            System.out.println("Vitamin id: " + vitamins[i].getId() + "\nVitamin producer: " + vitamins[i].getProducer() + "\nVitamin name: " + vitamins[i].getName() + "\nPrice: " + vitamins[i].getPrice() + " lei\nDiscount: " + vitamins[i].getDiscount() + "\nWeight: " + vitamins[i].getWeight() + " kg\nFlavour: " + vitamins[i].getFlavour() + "\nForm: " + vitamins[i].getForm() + "\nType: " + vitamins[i].getType());
            System.out.println("***********************");
        }
    }
}
