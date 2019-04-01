package shop.domain.entity;

public class Vitamin extends Product {
    private String type;
    private String form;
    private static int currentVitamin = 0;

    public String getType() {
        return type;
    }

    public String getForm() {
        return form;
    }

    public static int getCurrentVitamin() {
        return currentVitamin;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public static void increaseCurrentVitamin() {
        Vitamin.currentVitamin++;
    }
}
