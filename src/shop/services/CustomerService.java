package shop.services;

import shop.configuration.RepositoryConfiguration;
import shop.domain.entity.Customer;
import shop.domain.repository.CustomerRepository;
import shop.tool.AddCustomer;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerService {
    private CustomerRepository customerRepository = RepositoryConfiguration.getInstance().getCustomerRepository();

    protected Customer getCustomerById (int id) {
        return customerRepository.getCustomerById(id);
    }

    public boolean checkEmailPassword(String email, String password) {
        Customer customerByEmail = customerRepository.getCustomerByEmail(email);
        if (customerByEmail == null)
            return false;
        if (customerByEmail.checkPassword(password))
            return true;
        return false;
    }

    public void addCustomer (Customer newCustomer) {
        if (newCustomer == null) {
            AddCustomer.addCustomer();
        } else {
            System.out.println("You already have an account!");
        }
    }

    public boolean addCustomer (ArrayList<String> customerInfo) {
        String action = "Add customer";
        CsvService.writeAudit(action);
        return AddCustomer.addCustomer(customerInfo);
    }

    public Customer logIn (Customer loggedCustomer) {
        Scanner scanner = new Scanner(System.in);
        boolean tryAgain = true;
        String password;
        String email;
        String action = "Log In";
        CsvService.writeAudit(action);
        CustomerService customerService = new CustomerService();
        if (loggedCustomer == null) {
            do {
                System.out.println("Please type your email: ");
                email = scanner.nextLine();
                System.out.println("Please type your password to log in: ");
                password = scanner.nextLine();
                boolean validLogIn = customerService.checkEmailPassword(email, password);
                if (validLogIn == false) {
                    System.out.println("Invalid email or password. Try again? y/n");
                    String choiceTryAgain;
                    String choiceAddCustomer;
                    do {
                        choiceTryAgain = scanner.nextLine();
                        if (choiceTryAgain.equals("n") || choiceTryAgain.equals("N")) {
                            System.out.println("Add new customer? y/n");
                            do {
                                choiceAddCustomer = scanner.nextLine();
                                if (choiceAddCustomer.equals("y") || choiceAddCustomer.equals("Y")) {
                                    action = "Add customer";
                                    CsvService.writeAudit(action);
                                    AddCustomer.addCustomer();
                                    System.out.println("Added customer!");
                                }
                            } while (!choiceAddCustomer.equals("y") && !choiceAddCustomer.equals("Y") && !choiceAddCustomer.equals("n") && !choiceAddCustomer.equals("N"));
                            tryAgain = false;
                        } else if (choiceTryAgain.equals("y") || choiceTryAgain.equals("Y")) {
                            tryAgain = true;
                        }
                    } while (!choiceTryAgain.equals("y") && !choiceTryAgain.equals("Y") && !choiceTryAgain.equals("n") && !choiceTryAgain.equals("N"));
                } else {
                    loggedCustomer = customerRepository.getCustomerByEmail(email);
                    System.out.println("You are logged in!");
                    tryAgain = false;
                }
            } while (tryAgain != false);
        } else {
            System.out.println("You are already logged in!");
        }
        return loggedCustomer;
    }

    public Customer logIn (String email, String password) {
        String action = "Log In";
        CsvService.writeAudit(action);
        Customer loggedCustomer;
        boolean validLogIn = checkEmailPassword(email, password);
        if (validLogIn == false) {
            return null;
        } else {
            loggedCustomer = customerRepository.getCustomerByEmail(email);
        }
        return loggedCustomer;
    }

    public boolean deleteAccount(Customer loggedCustomer) {
//        if (loggedCustomer != null) {
//            customerRepository.deleteAccount(loggedCustomer.getEmail());
//        } else {
//            System.out.println("You need to be logged in!");
//        }
        return customerRepository.deleteAccount(loggedCustomer.getEmail());
    }

    public void updateEmail (Customer loggedCustomer) {
        if (loggedCustomer != null) {
            customerRepository.updateEmail(loggedCustomer.getEmail());
        } else {
            System.out.println("You need to be logged in!");
        }
    }

    public boolean updateEmail(Customer loggedCustomer, String newEmail) {
        Customer existingCustomer = CustomerRepository.getCustomerByEmail(newEmail);
        if (existingCustomer != null || !AddCustomer.emailMatcher(newEmail))
            return false;
        return customerRepository.updateEmail(loggedCustomer.getEmail(), newEmail);
    }
}
