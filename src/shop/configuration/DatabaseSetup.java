package shop.configuration;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseSetup {
    private static DatabaseSetup ourInstance = new DatabaseSetup();

    public static DatabaseSetup getInstance() {
        return ourInstance;
    }

    private DatabaseSetup() {
        try (Connection connection = ConnectionFactory.getConnection()) {
            Statement stmt = connection.createStatement();
            stmt.execute("drop table if exists customers");
            stmt.execute(
                    "create table " +
                            "customers (" +
                            "id number(4) PRIMARY KEY," +
                            "name varchar2(200)," +
                            "cnp varchar2(14)," +
                            "phone_number varchar2(20)," +
                            "email  varchar2(200)," +
                            "password varchar2(200)," +
                            "address varchar2(200)" +
                            ")");

            stmt.execute("drop table if exists invoices");
//            stmt.execute(
//                    "create table " +
//                            "invoices (" +
//                            "id number(4) PRIMARY KEY," +
//                            "value number(50)," +
//                            "payment_method varchar2(200)," +
//                            "client_id number(4) REFERENCES customers (id)," +
//                            "products varchar2(200)" +
//                            ")");

            stmt.execute("drop table if exists couriers");
            stmt.execute(
                    "create table " +
                            "couriers (" +
                            "id number(4) PRIMARY KEY," +
                            "name varchar2(200)," +
                            "cnp varchar2(14)," +
                            "phone_number varchar2(20)," +
                            "workzone  varchar2(200)," +
                            "driving_license number(20)" +
                            ")");

            stmt.execute("drop table if exists orders");
            stmt.execute(
                    "create table " +
                            "orders (" +
                            "id number(4) PRIMARY KEY," +
                            "client_id number(4) REFERENCES customers (id)," +
                            "invoice_id number(4)," +
                            "driving_license_courier number(14) REFERENCES couriers (driving_license)" +
                            ")");

            stmt.execute("drop table if exists producers");
            stmt.execute(
                    "create table " +
                            "producers (" +
                            "id number(4) PRIMARY KEY," +
                            "name varchar2(200)," +
                            "cui varchar2(200)," +
                            ")");

            stmt.execute("drop table if exists proteins");
//            stmt.execute(
//                    "create table " +
//                            "proteins (" +
//                            "id number(4) PRIMARY KEY," +
//                            "name varchar2(200)," +
//                            "price double(4)," +
//                            "discount double(4)," +
//                            "weight double(4)," +
//                            "flavour varchar2(200)," +
//                            "concentration double(4)," +
//                            "type varchar2(200)," +
//                            "producer_id number(14) REFERENCES producers (id)" +
//                            ")");

            stmt.execute("drop table if exists vitamins");
//            stmt.execute(
//                    "create table " +
//                            "vitamins (" +
//                            "id number(4) PRIMARY KEY," +
//                            "name varchar2(200)," +
//                            "price double(4)," +
//                            "discount double(4)," +
//                            "weight double(4)," +
//                            "flavour varchar2(200)," +
//                            "form varchar(200)," +
//                            "type varchar2(200)," +
//                            "producer_id number(14) REFERENCES producers (id)" +
//                            ")");

        } catch (SQLException ex) {
            System.out.println("Could not finish database setup!");
            ex.printStackTrace();
        }
    }
}
