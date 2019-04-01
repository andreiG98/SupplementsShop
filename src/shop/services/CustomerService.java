package shop.services;

import shop.configuration.RepositoryConfiguration;
import shop.domain.entity.Customer;
import shop.domain.repository.CustomerRepository;
import shop.tool.AddCustomer;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerService {
    private CustomerRepository customerRepository = RepositoryConfiguration.getInstance().getCustomerRepository();

    public CustomerService() {
        System.out.println("Creating Customer Service");
    }

    private ArrayList<Customer> getCustomersByASpecificPattern (String partialName) {
        Customer[] allCustomers = customerRepository.getCustomers();
        ArrayList<Customer> result = new ArrayList<Customer>();
        String pattern = createPattern(partialName);
        for (int i = 0; i < allCustomers.length; i++) {
            if (allCustomers[i] != null && allCustomers[i].getName().matches(pattern)) {
                result.add(allCustomers[i]);
            }
        }
        return result;
    }

    public void searchCustomersByASpecificPattern (String partialName) {
        ArrayList<Customer> result = getCustomersByASpecificPattern(partialName);
        Customer.show(result);
    }

    private String createPattern (String partialName) {
        String[] splitedPartialName = partialName.split("(?=[A-Z])");
        StringBuilder resultPattern = new StringBuilder();
        for (int i = 0; i < splitedPartialName.length; i++) {
            //System.out.println(splitedPartialName[i]);
            resultPattern.append(splitedPartialName[i]);
            resultPattern.append("[a-z]*");
            if (i != splitedPartialName.length - 1) {
                resultPattern.append("\\s");
                resultPattern.append("[[A-Z]*[.]*[a-z]*]*\\s");
            }
        }
        return resultPattern.toString();
    }

    public CustomerRepository getCustomerRepository() {
        return customerRepository;
    }

    public boolean checkEmailPassword(String email, String password) {
        Customer customerByEmail = customerRepository.getCustomerByEmail(email);
        if (customerByEmail == null)
            return false;
        if (customerByEmail.checkPassword(password))
            return true;
        return false;
    }

    public void addCustomer (boolean loggedIn) {
        if (loggedIn == false) {
            AddCustomer.addCustomer();
        } else {
            System.out.println("You already have an account!");
        }
    }

    public boolean logIn (boolean loggedIn) {
        Scanner scanner = new Scanner(System.in);
        boolean tryAgain = true;
        //boolean loggedIn = false;
        String password;
        String email;
        CustomerService customerService = new CustomerService();
        if (loggedIn == false) {
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
                    System.out.println("You are logged in!");
                    tryAgain = false;
                    loggedIn = true;
                }
            } while (tryAgain != false);
        } else {
            System.out.println("You are already logged in!");
        }
        return loggedIn;
    }
}
