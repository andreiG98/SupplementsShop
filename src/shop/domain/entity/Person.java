package shop.domain.entity;

abstract class Person {
    private int id;
    private String name;
    private long CNP;
    private String phoneNumber;

//    protected Person(int id, String name, long CNP, String phoneNumber) {
//        this.id = id;
//        this.name = name;
//        this.CNP = CNP;
//        this.phoneNumber = phoneNumber;
//    }
//
//    public Person(Person person) {
//        this.id = person.id;
//        this.name = person.name;
//        this.CNP = person.CNP;
//        this.phoneNumber = person.phoneNumber;
//    }

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
