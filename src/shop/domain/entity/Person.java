package shop.domain.entity;

abstract class Person {
    private int id;
    private String name;
    private String CNP;
    private String phoneNumber;

    public int getId() {
        return id;
    }

    public String getCNP() {
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

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
