package shop.tool;

import shop.domain.entity.Customer;
import shop.domain.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddCustomer {

    public static boolean emailMatcher(String email) {
        Pattern pattern = Pattern.compile("[a-z-_.]+@[a-z]+.[a-z]");
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }

    public static void addCustomer () {

        String name;
        String CNP;
        String phoneNumber;
        String email;
        String password;
        String address;
        String street;
        String numberOfStreet;
        Customer existingCustomer;
        int sector;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type in name: ");
        name = scanner.nextLine();
        System.out.println("Type in CNP: ");
        CNP = scanner.nextLine();
        System.out.println("Type in phoneNumber: ");
        phoneNumber = scanner.nextLine();
        System.out.println("Type in email: ");
        email = scanner.nextLine();
        while (!emailMatcher(email)) {
            System.out.println("Type a valid email: ");
            email = scanner.nextLine();
        }
        existingCustomer = CustomerRepository.getCustomerByEmail(email);
        while (existingCustomer != null) {
            System.out.println("Email is already in use!\nChoose another email!");
            email = scanner.nextLine();
            existingCustomer = CustomerRepository.getCustomerByEmail(email);
        }
        System.out.println("Type in password: ");
        password = scanner.nextLine();
        System.out.println("Type in address");
        System.out.println("Street:");
        street = scanner.nextLine();
        System.out.println("Number of Street:");
        numberOfStreet = scanner.nextLine();
        do {
            System.out.println("Sector: (1-6)");
            sector = scanner.nextInt();
        } while(sector < 1 || sector > 6);
        address = numberOfStreet + ' ' + street + ' ' + Integer.toString(sector);
    }

    public static boolean addCustomer (ArrayList<String> customerInfo) {
        String name;
        String CNP;
        String phoneNumber;
        String email;
        String password;
        String address;
        String street;
        String numberOfStreet;
        Customer existingCustomer;
        int sector;
        name = customerInfo.get(0) + " " + customerInfo.get(1);
        CNP = customerInfo.get(2);
        phoneNumber = customerInfo.get(3);
        email = customerInfo.get(4);
        password = customerInfo.get(5);
        street = customerInfo.get(6);
        numberOfStreet = customerInfo.get(7);
        sector = Integer.parseInt(customerInfo.get(8));
        address = numberOfStreet + ' ' + street + ' ' + sector;
        existingCustomer = CustomerRepository.getCustomerByEmail(email);

        if (existingCustomer != null || !emailMatcher(email))
            return false;

        Customer newCustomer =
                new CustomerBuilder()
                        .withName(name)
                        .withCNP(CNP)
                        .withPhoneNumber(phoneNumber)
                        .withEmail(email)
                        .withPassword(password)
                        .withAddress(address)
                        .build();
        CustomerRepository.addCustomer(newCustomer);

        return true;
    }
}
