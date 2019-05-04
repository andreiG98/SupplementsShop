package shop.domain.repository;

import shop.domain.entity.Producer;
import shop.tool.ProducerBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProducerRepository {
    private ArrayList<Producer> producers;
    private static File file;

    public ProducerRepository (String fileName) {
        file = new File(fileName);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(fileInputStream);
        this.producers = new ArrayList<Producer>(10);
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            String[] splitedData = line.split(", ");
            Producer newEntry =
                    new ProducerBuilder()
                            .withId()
                            .withName(splitedData[0])
                            .withCUI(Long.parseLong(splitedData[1]))
                            .build();
            producers.add(newEntry);
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
        }
    }

    public ArrayList<Producer> getProducers() {
        return producers;
    }
}
