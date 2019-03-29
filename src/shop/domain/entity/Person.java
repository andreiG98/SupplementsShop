package shop.domain.entity;

abstract class Person {
    private int id;
    private String name;
    private long CNP;
    private String phoneNumber;

    public int getId() {
        return id;
    }

    public long getCNP() {
        return CNP;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCNP(long CNP) {
        this.CNP = CNP;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
