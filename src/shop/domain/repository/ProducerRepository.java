package shop.domain.repository;

import shop.domain.entity.Producer;
import shop.tool.ProducerBuilder;
import shop.tool.TestData;

public class ProducerRepository {
    private Producer[] producers;

    public ProducerRepository () {
        int length = TestData.getInstance().getProducersData().length;
        this.producers = new Producer[length];
        for (int i = 0; i < length; i++) {
            String [] splitedData = TestData.getInstance().getProducersData()[i].split(";");
            this.producers[i] =
                    new ProducerBuilder()
                            .withId()
                            .withName(splitedData[0])
                            .withCUI(Long.parseLong(splitedData[1]))
                            .build();
        }
    }

    public Producer getProducerById (int id) {
        for (int i = 0; i < producers.length; i++) {
            if (producers[i].getId() == id) {
                return producers[i];
            }
        }
        return null;
    }

    public Producer getProducerByName (String name) {
        for (int i = 0; i < producers.length; i++) {
            if (producers[i].getName().equals(name)) {
                return producers[i];
            }
        }
        return null;
    }

    public Producer getProducerByCUI (long CUI) {
        for (int i = 0; i < producers.length; i++) {
            if (producers[i].getCUI() == CUI) {
                return producers[i];
            }
        }
        return null;
    }

    public void listtAllProducers () {
        for (int i = 0; i < producers.length; i++) {
            System.out.println("Produicer id: " + producers[i].getId() + "\nProducer name: " + producers[i].getName() + "\nProducer CUI: " + producers[i].getCUI());
        }
    }

    public Producer[] getProducers() {
        return producers;
    }
}
