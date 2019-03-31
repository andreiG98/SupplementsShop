package shop;

import shop.domain.repository.ProteinRepository;

public class Run {

    public static void main(String[] args) {
	// write your code here


        System.out.println("Welcome to Andrew's Supplemets Shop!");
//        while(1) {
//
//        }

        ProteinRepository proteinRepository = new ProteinRepository();
        proteinRepository.listAllProteins();

    }
}
