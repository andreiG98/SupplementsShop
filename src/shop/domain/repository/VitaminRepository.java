package shop.domain.repository;

import shop.domain.entity.Vitamin;

import java.util.ArrayList;

public class VitaminRepository {
    private Vitamin[] vitamins;

    public ArrayList<Vitamin> getVitaminsByForm (String form) {
        ArrayList<Vitamin> vitaminsByForm = new ArrayList<Vitamin>();
        for (int i = 0; i < vitamins.length; i++) {
            if (vitamins[i].getForm().equals(form))
                vitaminsByForm.add(vitamins[i]);
        }
        return vitaminsByForm;
    }

    public ArrayList<Vitamin> getVitaminsBy (String type) {
        ArrayList<Vitamin> vitaminsByType = new ArrayList<Vitamin>();
        for (int i = 0; i < vitamins.length; i++) {
            if (vitamins[i].getType().equals(type))
                vitaminsByType.add(vitamins[i]);
        }
        return vitaminsByType;
    }
}
