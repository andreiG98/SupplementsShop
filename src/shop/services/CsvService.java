package shop.services;

import java.io.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class CsvService {

    private static final String path = "D:\\JavaProjects\\SupplementsShop\\src\\shop\\configuration\\";
    private static final String fileName = "audit.csv";
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
    protected static void writeAudit(String action) {
        File file = new File(path + fileName);
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file, true)))) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            writer.write(action + ' ');
            writer.write(String.valueOf(timestamp) + "\n");

            System.out.println("done!");

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
