package shop.domain.entity;

public class Protein extends Product {
    private double concentration;
    private String type;
    private static int currentProtein = 0;

    public static int getCurrentProtein() {
        return currentProtein;
    }

    public static void increaseCurrentProtein() {
        Protein.currentProtein++;
    }


    public double getConcentration() {
        return concentration;
    }

    public String getType() {
        return type;
    }

    public void setConcentration(double concentration) {
        this.concentration = concentration;
    }

    public void setType(String type) {
        this.type = type;
    }
}
