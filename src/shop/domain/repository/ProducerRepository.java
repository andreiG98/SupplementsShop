package shop.domain.repository;

import shop.domain.entity.Producer;

public class ProducerRepository {
    private Producer[] producers;

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
}
