package shop.tool;

public class TestData {
    private static TestData ourInstance = new TestData();

    private String[] courierData = new String[] {
            "Oren W. Knight;1629072288399;(01641) 211923;Sector 1;16711887",
            "Jaquelyn L. Mccall;1615092035399;(0141) 794 0577;Sector 2;5815994",
            "Kyle I. Levy;1661052792299;(01333) 839925;Sector 3;41445184",
            "Alexandra Q. Padilla;1611031661099;0800 1111;Sector 3;17055806",
            "Joan T. Hunt;1681080243099;(025) 1607 1693;Sector 4;35267030",
            "Richard X. Figueroa;1608111362199;0845 46 45;Sector 5;24184169",
            "Yoshio X. Rowland;1656012303799;0500 391395;Sector 6;49062879"
    };

    private String[] proteinData = new String[] {
            "Milk and Egg;120;0;1;chocolate;0.8;universal;Vitabolic",
            "Soy Protein;100;0.4;0.8;vanilla;0.6;vegetarian, vegan;MyProtein"
    };

    private String[] vitaminData = new String[] {
            "Multivitamin;40;0.2;0.3;none;powder;men;MyProtein",
            "Vitamin C;20;0;0.1;orange;effervescent;universal;Vitabolic"
    };

    private String[] producersData = new String[] {
            "Vitabolic;293818827",
            "MyProtein;293283831"
    };

    public static TestData getInstance() {
        return ourInstance;
    }

    public String[] getCourierData() {
        return courierData;
    }

    public String[] getProteinData() {
        return proteinData;
    }

    public String[] getVitaminData() {
        return vitaminData;
    }

    public String[] getProducersData() {
        return producersData;
    }

    private TestData() {

    }
}
