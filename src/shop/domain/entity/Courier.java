package shop.domain.entity;

public class Courier extends Person {
    private String workZone;
    private int drivingLicenseNo;
    private static int currentCourier = 0;

    public String getWorkZone() {
        return workZone;
    }

    public int getDrivingLicenseNo() {
        return drivingLicenseNo;
    }

    public void setWorkZone(String workZone) {
        this.workZone = workZone;
    }

    public void setDrivingLicenseNo(int drivingLicenseNo) {
        this.drivingLicenseNo = drivingLicenseNo;
    }

    public static int getCurrentCourier() {
        return currentCourier;
    }

    public static void increaseCurrentCourier() {
        Courier.currentCourier++;
    }
}
