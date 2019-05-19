package shop.domain.repository;

import shop.configuration.ConnectionFactory;
import shop.domain.entity.Customer;
import shop.tool.CustomerBuilder;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerRepository {
    static private ArrayList<Customer> customers;
    private static File file;
    private static final String GET_CUSTOMER_BY_ID = "SELECT * FROM customers WHERE id=?";
    private static final String GET_ALL_USERS = "SELECT * FROM customers";
    private static final String CREATE_NEW_CUSTOMER = "INSERT INTO customers (id, name, cnp, phone_number, email, password, address) VALUES (?,?,?,?,?,?,?)";

    public CustomerRepository (String fileName) {
        file = new File(fileName);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(fileInputStream);
        this.customers = new ArrayList<Customer>(10);
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            String[] splitedData = line.split(", ");
            Customer newEntry =
                    new CustomerBuilder()
                            .withId()
                            .withName(splitedData[0])
                            .withCNP(splitedData[1])
                            .withPhoneNumber(splitedData[2])
                            .withEmail(splitedData[3])
                            .withPassword(splitedData[4])
                            .withAddress(splitedData[5])
                            .build();
            customers.add(newEntry);
        }
    }

    public CustomerRepository () {
//        file = new File(fileName);
//        FileInputStream fileInputStream = null;
//        try {
//            fileInputStream = new FileInputStream(file);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        Scanner scanner = new Scanner(fileInputStream);
//        this.customers = new ArrayList<Customer>(10);
//        while (scanner.hasNext()){
//            String line = scanner.nextLine();
//            String[] splitedData = line.split(", ");
//            Customer newEntry =
//                    new CustomerBuilder()
//                            .withId()
//                            .withName(splitedData[0])
//                            .withCNP(splitedData[1])
//                            .withPhoneNumber(splitedData[2])
//                            .withEmail(splitedData[3])
//                            .withPassword(splitedData[4])
//                            .withAddress(splitedData[5])
//                            .build();
//            customers.add(newEntry);
//        }
    }

    public static void addCustomer (Customer newCustomer) {

        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter(file, true));
            String newEntry = "\n";
            newEntry += newCustomer.toString();
            customers.add(newCustomer);
            out.write(newEntry);
            System.out.println("Customer added succesfully!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(out != null){
                    out.close();
                } else {
                    System.out.println("Buffer has not been initialized!");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(CREATE_NEW_CUSTOMER);
            String[] splitedDataCustomer = newCustomer.toString().split(", ");
            stmt.setInt(1, newCustomer.getId());
            stmt.setString(2, newCustomer.getName());
            stmt.setString(3, newCustomer.getCNP());
            stmt.setString(4, newCustomer.getPhoneNumber());
            stmt.setString(5, newCustomer.getEmail());
            stmt.setString(6, splitedDataCustomer[4]);
            stmt.setString(7, newCustomer.getAddress());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            //TODO
            ex.printStackTrace();
        }

    }

    public static Customer getCustomerById (int id) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() == id) {
                return customers.get(i);
            }
        }
        return null;
    }

    public Customer getCustomerByCNP (String CNP) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getCNP().equals(CNP)) {
                return customers.get(i);
            }
        }
        return null;
    }

    public Customer getCustomerByEmail (String email) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getEmail().equals(email)) {
                return customers.get(i);
            }
        }
        return null;
    }

    public void listAllCustomers () {
        for (int i = 0; i < customers.size(); i++) {
            System.out.println(customers.get(i).getId() + " " + customers.get(i).getName() + " " + customers.get(i).getCNP() + " " + customers.get(i).getPhoneNumber() + " " + customers.get(i).getEmail() + " " + customers.get(i).getAddress());
        }
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }


}
