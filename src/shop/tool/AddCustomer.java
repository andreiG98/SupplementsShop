package shop.tool;

import shop.domain.entity.Customer;
import shop.domain.repository.CustomerRepository;

import java.util.Scanner;

public class AddCustomer {
    static String[] customerData;

    public static void addCustomer () {
        String[] customerDataAux = TestData.getInstance().getCustomerData();
        String name;
        String CNP;
        String phoneNumber;
        String email;
        String password;
        String address;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type in name: ");
        name = scanner.nextLine();
        System.out.println("Type in CNP: ");
        CNP = scanner.nextLine();
        System.out.println("Type in phoneNumber: ");
        phoneNumber = scanner.nextLine();
        System.out.println("Type in email: ");
        email = scanner.nextLine();
        System.out.println("Type in password: ");
        password = scanner.nextLine();
        System.out.println("Type in address: ");
        address = scanner.nextLine();
        Customer newCustomer =
                new CustomerBuilder()
                        .withId()
                        .withName(name)
                        .withCNP(CNP)
                        .withPhoneNumber(phoneNumber)
                        .withEmail(email)
                        .withPassword(password)
                        .withAddress(password)
                        .build();
        CustomerRepository.addCustomer(newCustomer);
    }
}
