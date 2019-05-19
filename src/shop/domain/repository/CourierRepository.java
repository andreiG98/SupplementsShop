package shop.domain.repository;

import shop.configuration.ConnectionFactory;
import shop.domain.entity.Courier;
import shop.tool.CourierBuilder;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CourierRepository {
    private static ArrayList<Courier> couriers;
    private static File file;
    private static final String GET_CUSTOMER_BY_ID = "SELECT * FROM customers WHERE id=?";
    private static final String GET_ALL_COURIERS = "SELECT * FROM couriers";
    private static final String CREATE_NEW_CUSTOMER = "INSERT INTO customers (id, name, cnp, phone_number, email, password, address) VALUES (?,?,?,?,?,?,?)";

    public CourierRepository (String fileName) {
        file = new File(fileName);
        this.couriers = new ArrayList<Courier>(10);

        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(GET_ALL_COURIERS);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next())
            {
                Courier newEntry =
                        new CourierBuilder()
                                .withId()
                                .withName(resultSet.getString("name"))
                                .withCNP(resultSet.getString("cnp"))
                                .withPhoneNumber(resultSet.getString("phone_number"))
                                .withWorkZone(resultSet.getString("workzone"))
                                .withDrivingLicenseNo(resultSet.getInt("driving_license"))
                                .build();
                couriers.add(newEntry);
            }
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static Courier getCourierByDrivingLicense (int drivingLicense) {
        for (int i = 0; i < couriers.size(); i++) {
            if (couriers.get(i).getDrivingLicenseNo() == drivingLicense) {
                return couriers.get(i);
            }
        }
        return null;
    }

    public ArrayList<Courier> getCouriersByWorkZone (String workZone) {
        ArrayList<Courier> couriersByZone = new ArrayList<Courier>();
        for (int i = 0; i < couriers.size(); i++) {
            if (couriers.get(i).getWorkZone().equals(workZone)) {
                couriersByZone.add(couriers.get(i));
            }
        }
        return couriersByZone;
    }

    public void listAllCouriers () {
        for (int i = 0; i < couriers.size(); i++) {
            System.out.println(couriers.get(i).getId() + " " + couriers.get(i).getName() + " " + couriers.get(i).getCNP() + " " + couriers.get(i).getPhoneNumber() + " " + couriers.get(i).getWorkZone() + " " + couriers.get(i).getDrivingLicenseNo());
        }
    }
}
