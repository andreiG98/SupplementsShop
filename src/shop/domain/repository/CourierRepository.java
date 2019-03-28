package shop.domain.repository;

import shop.domain.entity.Courier;

import java.util.ArrayList;

public class CourierRepository {
    private Courier[] couriers;

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
            if (couriers[i].getWorkZone() == workZone) {
                couriersByZone.add(couriers[i]);
            }
        }
        return couriersByZone;
    }
}
