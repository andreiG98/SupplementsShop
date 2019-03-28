package shop.domain.entity;

public class Producer {
    private int id;
    private String name;
    private long CUI;
    private Product[] producedProducts;
    private static int currentProducer = 0;

    public Producer(String name, long CUI, Product[] producedProducts) {
        this.id = ++currentProducer;
        this.name = name;
        this.CUI = CUI;
        this.producedProducts = producedProducts;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getCUI() {
        return CUI;
    }
}
