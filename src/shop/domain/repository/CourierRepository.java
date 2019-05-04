package shop.domain.repository;

import shop.domain.entity.Courier;
import shop.tool.CourierBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CourierRepository {
    private static ArrayList<Courier> couriers;
    private static File file;

    public CourierRepository (String fileName) {
        file = new File(fileName);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(fileInputStream);
        this.couriers = new ArrayList<Courier>(10);

        while (scanner.hasNext()){
            String line = scanner.nextLine();
            String[] splitedData = line.split(", ");
            Courier newEntry =
                    new CourierBuilder()
                            .withId()
                            .withName(splitedData[0])
                            .withCNP(splitedData[1])
                            .withPhoneNumber(splitedData[2])
                            .withWorkZone(splitedData[3])
                            .withDrivingLicenseNo(Integer.parseInt(splitedData[4]))
                            .build();
            couriers.add(newEntry);
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
