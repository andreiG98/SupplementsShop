package shop.domain.entity;

public class Producer {
    private int id;
    private String name;
    private long CUI;
    private static int currentProducer = 0;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getCUI() {
        return CUI;
    }

    public static int getCurrentProducer() {
        return currentProducer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCUI(long CUI) {
        this.CUI = CUI;
    }

    public static void increaseCurrentProducer() {
        Producer.currentProducer++;
    }
}
