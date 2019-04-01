package shop;

import shop.services.OrderService;

public class Run {

    public static void main(String[] args) {
	// write your code here


        System.out.println("Welcome to Andrew's Supplemets Shop!");
//        while(1) {
//
//        }

//        ProteinRepository proteinRepository = new ProteinRepository();
//        proteinRepository.listAllProteins();
//
//        VitaminRepository vitaminRepository = new VitaminRepository();
//        vitaminRepository.listAllvitamins();

        OrderService orderService = new OrderService();
        orderService.addOrder();

    }
}
