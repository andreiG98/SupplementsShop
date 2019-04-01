package shop.tool;

import shop.domain.entity.Producer;

public class ProducerBuilder {
    private final Producer target = new Producer();

    public ProducerBuilder withId () {
        Producer.increaseCurrentProducer();
        int currentProducer = Producer.getCurrentProducer();
        target.setId(currentProducer);
        return this;
    }

    public ProducerBuilder withName (String name) {
        target.setName(name);
        return this;
    }

    public ProducerBuilder withCUI (long CUI) {
        target.setCUI(CUI);
        return this;
    }

    public Producer build () {
        return target;
    }
}
