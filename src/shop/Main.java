package shop;

import shop.domain.entity.Client;
import shop.domain.entity.Producer;
import shop.domain.entity.Product;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Producer prod1 = new Producer("Vitabolic", 12332, new Product[0]);
        Producer prod2 = new Producer("MyProtein", 15322, new Product[1]);

        System.out.println(prod1.getId());
        System.out.println(prod2.getId());

        Client client1 = new Client("Andrei", 121213, "0199292", "andrei", "asdadasd", "ajdsjsdjd");
        Client client2 = new Client("Andrei", 121213, "019928", "andrei", "asdadasd", "ajdsjsdjd");
        System.out.println(client1.getId());
        System.out.println(client2.getId());
    }
}
