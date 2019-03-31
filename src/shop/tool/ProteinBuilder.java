package shop.tool;

import shop.domain.entity.Protein;

public class ProteinBuilder {

    private final Protein target = new Protein();

    public ProteinBuilder withId () {
        Protein.increaseCurrentProtein();
        int currentProtein = Protein.getCurrentProtein();
        target.setId(currentProtein);
        return this;
    }

    public ProteinBuilder withName (String name) {
        target.setName(name);
        return this;
    }

    public ProteinBuilder withPrice (double price) {
        target.setPrice(price);
        return this;
    }

    public ProteinBuilder withDiscount (double discount) {
        target.setDiscount(discount);
        return this;
    }

    public ProteinBuilder withWeight (double weight) {
        target.setWeight(weight);
        return this;
    }

    public ProteinBuilder withFlavour (String flavour) {
        target.setFlavour(flavour);
        return this;
    }

    public ProteinBuilder withConcentration (double concentration) {
        target.setConcentration(concentration);
        return this;
    }

    public ProteinBuilder withType (String type) {
        target.setType(type);
        return this;
    }

    public Protein build() {
        return target;
    }
}
