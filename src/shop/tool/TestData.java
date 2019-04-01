package shop.tool;

public class TestData {
    private static TestData ourInstance = new TestData();

    private String[] customerData = new String[] {
            "Stephen W. Russell;1680081371499;(0112) 543 0402;ante@gravida.com;ZLH53AXA6DW;2633 Nulla Road",
            "Laith R. Moore;1690031395299;(01741) 301350;pulvinar.arcu.et@odioEtiamligula.net;RBX60GXY8HE;8857 Urna; Road",
            "Wilma F. Carrillo; 165912140745 ;(01060) 34862;vehicula@aliquamenimnec.edu;WWV14CNV0LB;245-8347 Massa Ave",
            "Fritz U. Castillo; 160709272587 ;(01846) 657787;ornare.elit.elit@Nam.com;RWM26YJS6HG;Ap #792-7798 Fermentum Rd.",
            "Graham L. Forbes; 169911036151 ;0800 1111;orci.Donec@at.ca;IBV56EJW0XG;Ap #263-678 Dictum. Street",
            "Mallory F. Shaw; 167512106035 ;(01013) 484944;a.magna.Lorem@dictum.co.uk;ERV12BZK5XI; P.O. Box 442, 4698 Bibendum Avenue" ,
            "Brody M. Frye; 167111259417 ;(023) 7681 2555;magnis.dis.parturient@liberoDonecconsectetuer.net;DDN17DCP2VV;Ap #643-8904 Ac Street",
            "Michelle W. Richmond; 167104155598 ;056 9482 4078;aptent.taciti@mi.com;DYO26KFA7GN; 5996 Nec, Road" ,
            "Daquan I. Burns; 167605217376 ;(016977) 0758;convallis.convallis.dolor@enim.net;VOZ75UFJ8FV;215 Gravida St.",
            "Otto N. Koch;1640050992799;0999 692 5799;vitae@egestas.com;LDH75ODH2JO;136-1606 Enim Avenue",
            "Dillon N. Conway;1638091093199;0800 225 4898;tortor.dictum@nunc.org;IAC53WOB4TF;P.O. Box 101, 8550 Nisl Street",
            "Bruno S. Mclean;1633122993999;0800 315139;enim.Curabitur@rutrum.ca;DZM75ZRM5UK;203-1563 Dui, Avenue",
            "Brock Y. Merritt;1656121368499;0500 005155;ac.ipsum@ut.org;PTR17VXX1DR;938-6288 Fusce Ave",
            "Blake P. Sandoval;1644062977199;(027) 1702 5176;tincidunt.neque.vitae@atrisus.net;IRG90DJH9XQ;415-1722 Tempor Rd.",
            "Guinevere Q. Collins;1635030776099;070 0712 0815;amet.faucibus.ut@odioEtiamligula.ca;CWO57OLJ4XR;362-1652 Arcu. Avenue",
            "Hashim F. Melendez;1639051454799;076 1518 0974;a.purus.Duis@mifringilla.org;YKQ56ZSG5SD;841-4706 Elit, St.",
            "Gidea Andrei;123213213;021838238;andrei.gadea;1234;Pucheni"
    };

    private String[] courierData = new String[] {
            "Oren W. Knight;1629072288399;(01641) 211923;Sector 1;16711887",
            "Jaquelyn L. Mccall;1615092035399;(0141) 794 0577;Sector 2;5815994",
            "Kyle I. Levy;1661052792299;(01333) 839925;Sector 3;41445184",
            "Alexandra Q. Padilla;1611031661099;0800 1111;Sector 3;17055806",
            "Joan T. Hunt;1681080243099;(025) 1607 1693;Sector 4;35267030",
            "Richard X. Figueroa;1608111362199;0845 46 45;Sector 5;24184169",
            "Yoshio X. Rowland;1656012303799;0500 391395;49062879"
    };

    private String[] proteinData = new String[] {
            "Milk and Egg;120;0;1;chocolate;0.8;universal",
            "Soy Protein;100;0.4;0.8;vanilla;0.6;vegetarian, vegan"
    };

    private String[] vitaminData = new String[] {
            "Multivitamin;40;0.2;0.3;none;powder;men",
            "Vitamin C;20;0;0.1;orange;effervescent;universal"
    };

    public static TestData getInstance() {
        return ourInstance;
    }

    public String[] getCustomerData() {
        return customerData;
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

    private TestData() {

    }
}
