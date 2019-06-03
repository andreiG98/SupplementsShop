package shop.configuration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseSetup {
    private static DatabaseSetup ourInstance = new DatabaseSetup();

    public static DatabaseSetup getInstance() {
        return ourInstance;
    }

    private static final String ADD_COURIER = "INSERT INTO COURIERS (ID, NAME, CNP, PHONE_NUMBER, WORKZONE, DRIVING_LICENSE)  VALUES (?, ?, ?, ?, ?, ?);";

    private static final String ADD_PRODUCER = "INSERT INTO PRODUCERS (ID, NAME, CUI)  VALUES (?, ?, ?);";

    private static final String CUSTOMER_SEQUENCE = "CREATE SEQUENCE customer_seq START WITH 1 INCREMENT BY 1 MAXVALUE 999 NOCYCLE;";

    private DatabaseSetup() {
        try (Connection connection = ConnectionFactory.getConnection()) {
            Statement stmt = connection.createStatement();
            PreparedStatement stmtAdd;
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

            //stmt.execute("ALTER SEQUENCE customer_seq RESTART WITH 1;");
            //stmt.execute(CUSTOMER_SEQUENCE);

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

            stmtAdd = connection.prepareStatement(ADD_COURIER);

            stmtAdd.setInt(1, 1);
            stmtAdd.setString(2, "Oren W. Knight");
            stmtAdd.setString(3, "1629072288399");
            stmtAdd.setString(4, "(01641) 211923");
            stmtAdd.setString(5, "Sector 1");
            stmtAdd.setInt(6, 16711887);
            stmtAdd.executeUpdate();


            stmtAdd.setInt(1, 2);
            stmtAdd.setString(2, "Jaquelyn L. Mccal");
            stmtAdd.setString(3, "1615092035399");
            stmtAdd.setString(4, "(0141) 794 0577");
            stmtAdd.setString(5, "Sector 2");
            stmtAdd.setInt(6, 5815994);
            stmtAdd.executeUpdate();

            stmtAdd.setInt(1, 3);
            stmtAdd.setString(2, "Kyle I. Levy");
            stmtAdd.setString(3, "1661052792299");
            stmtAdd.setString(4, "(01333) 839925");
            stmtAdd.setString(5, "Sector 3");
            stmtAdd.setInt(6, 41445184);
            stmtAdd.executeUpdate();

            stmtAdd.setInt(1, 4);
            stmtAdd.setString(2, "Alexandra Q. Padilla");
            stmtAdd.setString(3, "1611031661099");
            stmtAdd.setString(4, "0800 1111");
            stmtAdd.setString(5, "Sector 3");
            stmtAdd.setInt(6, 17055806);
            stmtAdd.executeUpdate();

            stmtAdd.setInt(1, 5);
            stmtAdd.setString(2, "Joan T. Hunt");
            stmtAdd.setString(3, "1681080243099");
            stmtAdd.setString(4, "(025) 1607 1693");
            stmtAdd.setString(5, "Sector 4");
            stmtAdd.setInt(6, 35267030);
            stmtAdd.executeUpdate();

            stmtAdd.setInt(1, 6);
            stmtAdd.setString(2, "Richard X. Figueroa");
            stmtAdd.setString(3, "1608111362199");
            stmtAdd.setString(4, "0845 46 45");
            stmtAdd.setString(5, "Sector 5");
            stmtAdd.setInt(6, 24184169);
            stmtAdd.executeUpdate();

            stmtAdd.setInt(1, 7);
            stmtAdd.setString(2, "Yoshio X. Rowland");
            stmtAdd.setString(3, "1656012303799");
            stmtAdd.setString(4, "0500 391395");
            stmtAdd.setString(5, "Sector 6");
            stmtAdd.setInt(6, 49062879);
            stmtAdd.executeUpdate();



            stmt.execute("drop table if exists orders");
            stmt.execute(
                    "create table " +
                            "orders (" +
                            "id number(4) PRIMARY KEY," +
                            "client_id number(4) REFERENCES customers (id) ON DELETE CASCADE," +
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

            stmtAdd = connection.prepareStatement(ADD_PRODUCER);

            stmtAdd.setInt(1, 1);
            stmtAdd.setString(2, "Vitabolic");
            stmtAdd.setString(3, "293818827");
            stmtAdd.executeUpdate();

            stmtAdd.setInt(1, 2);
            stmtAdd.setString(2, "MyProtein");
            stmtAdd.setString(3, "293283831");
            stmtAdd.executeUpdate();

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
