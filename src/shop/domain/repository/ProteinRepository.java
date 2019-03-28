package shop.domain.repository;

import shop.domain.entity.Protein;

import java.util.ArrayList;

public class ProteinRepository {
    private Protein[] proteins;

    public ArrayList<Protein> getProteinByConcentration (double concentration) {
        ArrayList<Protein> proteinsByConcentration = new ArrayList<Protein>();
        for (int i = 0; i < proteins.length; i++) {
            if (proteins[i].getConcentration() == concentration)
                proteinsByConcentration.add(proteins[i]);
        }
        return proteinsByConcentration;
    }

    public ArrayList<Protein> getProteinByConcentration (String type) {
        ArrayList<Protein> proteinsByType = new ArrayList<Protein>();
        for (int i = 0; i < proteins.length; i++) {
            if (proteins[i].getType().equals(type))
                proteinsByType.add(proteins[i]);
        }
        return proteinsByType;
    }
}
