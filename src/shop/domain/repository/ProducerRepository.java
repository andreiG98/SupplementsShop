package shop.domain.repository;

import shop.configuration.ConnectionFactory;
import shop.domain.entity.Producer;
import shop.tool.ProducerBuilder;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProducerRepository {
    private ArrayList<Producer> producers;
    private static File file;
    private static final String GET_ALL_PRODUCERS = "SELECT * FROM producers";

    public ProducerRepository (String fileName) {
        file = new File(fileName);
        this.producers = new ArrayList<Producer>(10);
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(GET_ALL_PRODUCERS);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next())
            {
                Producer newEntry =
                        new ProducerBuilder()
                                .withId()
                                .withName(resultSet.getString("name"))
                                .withCUI(resultSet.getLong("cui"))
                                .build();
                producers.add(newEntry);
            }
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Producer getProducerById (int id) {
        for (int i = 0; i < producers.size(); i++) {
            if (producers.get(i).getId() == id) {
                return producers.get(i);
            }
        }
        return null;
    }

    public Producer getProducerByName (String name) {
        for (int i = 0; i < producers.size(); i++) {
            if (producers.get(i).getName().equals(name)) {
                return producers.get(i);
            }
        }
        return null;
    }

    public Producer getProducerByCUI (long CUI) {
        for (int i = 0; i < producers.size(); i++) {
            if (producers.get(i).getCUI() == CUI) {
                return producers.get(i);
            }
        }
        return null;
    }

    public void listtAllProducers () {
        for (int i = 0; i < producers.size(); i++) {
            System.out.println("Producer id: " + producers.get(i).getId() + "\nProducer name: " + producers.get(i).getName() + "\nProducer CUI: " + producers.get(i).getCUI());
            System.out.println("***************************");
        }
    }

    public ArrayList<Producer> getProducers() {
        return producers;
    }
}
