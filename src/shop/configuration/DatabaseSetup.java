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
                            "phone_number varchar2(11)," +
                            "email  varchar2(200)," +
                            "password varchar2(200)," +
                            "address varchar2(200)" +
                            ")");

            stmt.execute("drop table if exists invoices");
            stmt.execute(
                    "create table " +
                            "invoices (" +
                            "id number(4) PRIMARY KEY," +
                            "value number(50)," +
                            "payment_method varchar2(200)," +
                            "client_id number(4) REFERENCES customers (id)," +
                            "products varchar2(200)" +
                            ")");

            stmt.execute("drop table if exists couriers");
            stmt.execute(
                    "create table " +
                            "couriers (" +
                            "id number(4) PRIMARY KEY," +
                            "name varchar2(200)," +
                            "cnp varchar2(14)," +
                            "phone_number varchar2(11)," +
                            "workzone  varchar2(200)," +
                            "driving_license number(20)" +
                            ")");

            stmt.execute("drop table if exists orders");
            stmt.execute(
                    "create table " +
                            "orders (" +
                            "id number(4) PRIMARY KEY," +
                            "client_id number(4) REFERENCES customers (id)," +
                            "invoice_id number(4) REFERENCES invoices (id)," +
                            "driving_license_courier number(14) REFERENCES couriers (driving_license)" +
                            ")");

            stmt.execute("drop table if exists producers");
            stmt.execute(
                    "create table " +
                            "producers (" +
                            "id number(4) PRIMARY KEY," +
                            "name varchar2(200)," +
                            "cnp number(14)," +
                            "phone_number number(11)," +
                            "email  varchar2(200)," +
                            "password varchar2(200)," +
                            "address varchar2(200)" +
                            ")");

            stmt.execute("drop table if exists products");
            stmt.execute(
                    "create table " +
                            "products (" +
                            "id number(4) PRIMARY KEY," +
                            "name varchar2(200)," +
                            "cnp number(14)," +
                            "phone_number number(11)," +
                            "email  varchar2(200)," +
                            "password varchar2(200)," +
                            "address varchar2(200)" +
                            ")");
            //stmt.execute("drop sequence if exists user_id_seq");
            //stmt.execute("create sequence user_id_seq");
        } catch (SQLException ex) {
            System.out.println("Could not finish database setup!");
            ex.printStackTrace();
        }
    }
}
