package shop.domain.repository;

import shop.configuration.ConnectionFactory;
import shop.domain.entity.Customer;
import shop.tool.AddCustomer;
import shop.tool.CustomerBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CustomerRepository {
    private static final String GET_CUSTOMER_BY_ID = "SELECT * FROM customers WHERE id = ?";
    private static final String GET_CUSTOMER_BY_EMAIL = "SELECT * FROM customers WHERE email = ?";
    private static final String GET_CUSTOMER_BY_CNP = "SELECT * FROM customers WHERE cnp = ?";
    private static final String CREATE_NEW_CUSTOMER = "INSERT INTO customers (id, name, cnp, phone_number, email, password, address) VALUES (?,?,?,?,?,?,?)";
    private static final String DELETE_CUSTOMER = "DELETE FROM customers WHERE email = ?";
    private static final String UPDATE_EMAIL_CUSTOMER = "UPDATE customers SET email = ? WHERE email = ?";
    private static final String customerID = "select customer_seq.NEXTVAL from dual";

    public CustomerRepository () {}

    public static void addCustomer (Customer newCustomer) {

        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(CREATE_NEW_CUSTOMER);
            PreparedStatement pst = connection.prepareStatement(customerID);
            ResultSet rs = pst.executeQuery();
            int custId = 0;
            if(rs.next())
                custId = rs.getInt(1);
            String[] splitedDataCustomer = newCustomer.toString().split(", ");
            stmt.setInt(1, custId);
            stmt.setString(2, newCustomer.getName());
            stmt.setString(3, newCustomer.getCNP());
            stmt.setString(4, newCustomer.getPhoneNumber());
            stmt.setString(5, newCustomer.getEmail());
            stmt.setString(6, splitedDataCustomer[4]);
            stmt.setString(7, newCustomer.getAddress());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static Customer getCustomerById (int id) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(GET_CUSTOMER_BY_ID);
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                Customer customerById =
                        new CustomerBuilder()
                                .withName(resultSet.getString("name"))
                                .withCNP(resultSet.getString("cnp"))
                                .withPhoneNumber(resultSet.getString("phone_number"))
                                .withEmail(resultSet.getString("email"))
                                .withPassword(resultSet.getString("password"))
                                .withAddress(resultSet.getString("address"))
                                .build();
                customerById.setId(id);
                return customerById;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Customer getCustomerByCNP (String CNP) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(GET_CUSTOMER_BY_CNP);
            stmt.setString(1, CNP);
            ResultSet resultSet = stmt.executeQuery();
            resultSet.next();
            if (resultSet != null) {
                Customer customerById =
                        new CustomerBuilder()
                                .withName(resultSet.getString("name"))
                                .withCNP(resultSet.getString("cnp"))
                                .withPhoneNumber(resultSet.getString("phone_number"))
                                .withEmail(resultSet.getString("email"))
                                .withPassword(resultSet.getString("password"))
                                .withAddress(resultSet.getString("address"))
                                .build();
                customerById.setId(resultSet.getInt("id"));
                return customerById;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static Customer getCustomerByEmail (String email) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(GET_CUSTOMER_BY_EMAIL);
            stmt.setString(1, email);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                Customer customerById =
                        new CustomerBuilder()
                                .withName(resultSet.getString("name"))
                                .withCNP(resultSet.getString("cnp"))
                                .withPhoneNumber(resultSet.getString("phone_number"))
                                .withEmail(resultSet.getString("email"))
                                .withPassword(resultSet.getString("password"))
                                .withAddress(resultSet.getString("address"))
                                .build();
                customerById.setId(resultSet.getInt("id"));
                return customerById;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean deleteAccount(String email) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(DELETE_CUSTOMER);
            stmt.setString(1, email);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void updateEmail(String email) {
        String newEmail;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type new email");
        newEmail = scanner.nextLine();
        while (!AddCustomer.emailMatcher(newEmail)) {
            System.out.println("Type a valid email: ");
            newEmail = scanner.nextLine();
        }
    }

    public boolean updateEmail(String email, String newEmail) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(UPDATE_EMAIL_CUSTOMER);
            stmt.setString(1, newEmail);
            stmt.setString(2, email);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
