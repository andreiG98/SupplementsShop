package shop.domain.entity;

public class Seller extends Person {
    private double salary;
    private int[] workProgram;
    private static int currentSeller = 0;

    public Seller(String name, long CNP, String phoneNumber, double salary, int[] workProgram) {
        super(++currentSeller, name, CNP, phoneNumber);
        this.salary = salary;
        for (int i = 0; i < workProgram.length; i++) {
            this.workProgram[i] = workProgram[i];
        }
    }

    public double getSalary() {
        return salary;
    }

    public int[] getWorkProgram() {
        return workProgram;
    }
}
