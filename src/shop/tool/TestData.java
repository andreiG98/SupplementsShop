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
            "Daquan I. Burns; 167605217376 ;(016977) 0758;convallis.convallis.dolor@enim.net;VOZ75UFJ8FV;215 Gravida St."
    };

    public static TestData getInstance() {
        return ourInstance;
    }

    public String[] getCustomerData() {
        return customerData;
    }

    private TestData() {

    }
}
