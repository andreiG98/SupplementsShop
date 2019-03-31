package shop.domain.repository;

import shop.domain.entity.Courier;
import shop.tool.CourierBuilder;
import shop.tool.TestData;

import java.util.ArrayList;

public class CourierRepository {
    private Courier[] couriers;

    public CourierRepository () {
        int length = TestData.getInstance().getCourierData().length;
        this.couriers = new Courier[length];
        for (int i = 0; i < length; i++) {
            String [] splitedData = TestData.getInstance().getCourierData()[i].split(";");
            this.couriers[i] =
                    new CourierBuilder()
                            .withId()
                            .withName(splitedData[0])
                            .withCNP(splitedData[1])
                            .withPhoneNumber(splitedData[2])
                            .withWorkZone(splitedData[3])
                            .withDrivingLicenseNo(Integer.parseInt(splitedData[4]))
                            .build();

        }
    }

    public Courier getCourierByDrivingLicense (int drivingLicense) {
        for (int i = 0; i < couriers.length; i++) {
            if (couriers[i].getId() == drivingLicense) {
                return couriers[i];
            }
        }
        return null;
    }

    public ArrayList<Courier> getCouriersByWorkZone (String workZone) {
        ArrayList<Courier> couriersByZone = new ArrayList<Courier>();
        for (int i = 0; i < couriers.length; i++) {
            if (couriers[i].getWorkZone().equals(workZone)) {
                couriersByZone.add(couriers[i]);
            }
        }
        return couriersByZone;
    }

    public void listAllCouriers () {
        for (int i = 0; i < couriers.length; i++) {
            System.out.println(couriers[i].getId() + " " + couriers[i].getName() + " " + couriers[i].getCNP() + " " + couriers[i].getPhoneNumber() + " " + couriers[i].getWorkZone() + " " + couriers[i].getDrivingLicenseNo());
        }
    }
}
