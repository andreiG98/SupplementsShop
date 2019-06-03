package shop.domain.repository;

import shop.configuration.ConnectionFactory;
import shop.domain.entity.Courier;
import shop.tool.CourierBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CourierRepository {
    private static final String GET_COURIER_BY_DRIVING_LICENSE = "SELECT * FROM couriers WHERE driving_license=?";
    private static final String GET_COURIER_BY_WORK_ZONE = "SELECT * FROM couriers WHERE workzone=?";

    public CourierRepository () {}

    public static Courier getCourierByDrivingLicense (int drivingLicense) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(GET_COURIER_BY_DRIVING_LICENSE);
            stmt.setInt(1, drivingLicense);
            ResultSet resultSet = stmt.executeQuery();
            resultSet.next();
            if (resultSet != null) {
                Courier courierByDL =
                        new CourierBuilder()
                                .withName(resultSet.getString("name"))
                                .withCNP(resultSet.getString("cnp"))
                                .withPhoneNumber(resultSet.getString("phone_number"))
                                .withWorkZone(resultSet.getString("workzone"))
                                .withDrivingLicenseNo(resultSet.getInt("driving_license"))
                                .build();
                courierByDL.setId(resultSet.getInt("id"));
                return courierByDL;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public ArrayList<Courier> getCouriersByWorkZone (String workZone) {
        ArrayList<Courier> couriersByZone = new ArrayList<Courier>();

        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(GET_COURIER_BY_WORK_ZONE);
            stmt.setString(1, workZone);
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
                couriersByZone.add(newEntry);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return couriersByZone;
    }
}
