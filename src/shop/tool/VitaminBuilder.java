package shop.tool;

import shop.domain.entity.Vitamin;

public class VitaminBuilder {

    private final Vitamin target = new Vitamin();

    public VitaminBuilder withId () {
        Vitamin.increaseCurrentVitamin();
        int currentVitamin = Vitamin.getCurrentVitamin();
        target.setId(currentVitamin);
        return this;
    }

    public VitaminBuilder withName (String name) {
        target.setName(name);
        return this;
    }

    public VitaminBuilder withPrice (double price) {
        target.setPrice(price);
        return this;
    }

    public VitaminBuilder withDiscount (double discount) {
        target.setDiscount(discount);
        return this;
    }

    public VitaminBuilder withWeight (double weight) {
        target.setWeight(weight);
        return this;
    }

    public VitaminBuilder withFlavour (String flavour) {
        target.setFlavour(flavour);
        return this;
    }

    public VitaminBuilder withForm (String form) {
        target.setForm(form);
        return this;
    }

    public VitaminBuilder withType (String type) {
        target.setType(type);
        return this;
    }

    public Vitamin build() {
        return target;
    }
}
