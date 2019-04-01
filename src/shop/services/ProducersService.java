package shop.services;

import shop.configuration.RepositoryConfiguration;
import shop.domain.entity.Producer;
import shop.domain.repository.ProducerRepository;

import java.util.ArrayList;
import java.util.Scanner;

public class ProducersService {
    private ProducerRepository producerRepository = RepositoryConfiguration.getInstance().getProducerRepository();

    public void showProducers() {
        producerRepository.listtAllProducers();
    }

    private ArrayList<Producer> getProducersByASpecificPattern (String partialName) {
        Producer[] allProducers = producerRepository.getProducers();
        ArrayList<Producer> result = new ArrayList<Producer>();
        String pattern = createPattern(partialName);
        for (int i = 0; i < allProducers.length; i++) {
            if (allProducers[i] != null && allProducers[i].getName().matches(pattern)) {
                result.add(allProducers[i]);
            }
        }
        return result;
    }

    public void searchProducersByASpecificPattern () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give me name/partial name of producer:");
        String partialName = scanner.nextLine();
        ArrayList<Producer> result = getProducersByASpecificPattern(partialName);
        Producer.show(result);
    }

    private String createPattern (String partialName) {
        String[] splitedPartialName = partialName.split("(?=[A-Z])");
        StringBuilder resultPattern = new StringBuilder();
        for (int i = 0; i < splitedPartialName.length; i++) {
            resultPattern.append(splitedPartialName[i]);
            resultPattern.append("[a-z]*");
            resultPattern.append("[\\s]*");
            resultPattern.append("[[A-Z]*[a-z]*]*[\\s]*");
        }
        //System.out.println(resultPattern.toString());
        return resultPattern.toString();
    }

}
