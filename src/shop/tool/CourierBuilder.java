package shop.tool;

import shop.domain.entity.Courier;

public class CourierBuilder {
    private final Courier target = new Courier();

    public CourierBuilder withId () {
        Courier.increaseCurrentCourier();
        int currentCourier = Courier.getCurrentCourier();
        target.setId(currentCourier);
        return this;
    }

    public CourierBuilder withName (String name) {
        target.setName(name);
        return this;
    }

    public CourierBuilder withCNP (String CNP) {
        target.setCNP(CNP);
        return this;
    }

    public CourierBuilder withPhoneNumber (String phoneNumber) {
        target.setPhoneNumber(phoneNumber);
        return this;
    }

    public CourierBuilder withWorkZone (String workZone) {
        target.setWorkZone(workZone);
        return this;
    }

    public CourierBuilder withDrivingLicenseNo (int drivingLicenseNo) {
        target.setDrivingLicenseNo(drivingLicenseNo);
        return this;
    }

    public Courier build() {
        return target;
    }
}
