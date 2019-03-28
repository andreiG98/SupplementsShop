package shop.domain.entity;

public class Courier extends Person {
    private String workZone;
    private int drivingLicenseNo;
    private static int currentCourier = 0;

    public Courier(String name, long CNP, String phoneNumber, String workZone, int drivingLicenseNo) {
        super(++currentCourier, name, CNP, phoneNumber);
        this.workZone = workZone;
        this.drivingLicenseNo = drivingLicenseNo;
    }

    public Courier(Courier courier) {
        super(courier);
        this.workZone = courier.workZone;
        this.drivingLicenseNo = courier.drivingLicenseNo;
    }

    public String getWorkZone() {
        return workZone;
    }
}
