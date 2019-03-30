package shop.tool;

public class TestData {
    private static TestData ourInstance = new TestData();

    private String[] customerData = new String[] {
            "Stephen W. Russell;1680081371499;(0112) 543 0402;ante@gravida.com;ZLH53AXA6DW;2633 Nulla Road",
            "Laith R. Moore;1690031395299;(01741) 301350;pulvinar.arcu.et@odioEtiamligula.net;RBX60GXY8HE;8857 Urna, Road",
//            "Wilma F. Carrillo, 16591214,0745 ,(01060) 34862,vehicula@aliquamenimnec.edu,WWV14CNV0LB,245-8347 Massa Ave",
//            "Fritz U. Castillo, 16070927,2587 ,(01846) 657787,ornare.elit.elit@Nam.com,RWM26YJS6HG,Ap #792-7798 Fermentum Rd.",
//            "Graham L. Forbes, 16991103,6151 ,0800 1111,orci.Donec@at.ca,IBV56EJW0XG,Ap #263-678 Dictum. Street",
//            "Mallory F. Shaw, 16751210,6035 ,(01013) 484944,a.magna.Lorem@dictum.co.uk,ERV12BZK5XI, P.O. Box 442, 4698 Bibendum Avenue" ,
//            "Brody M. Frye, 16711125,9417 ,(023) 7681 2555,magnis.dis.parturient@liberoDonecconsectetuer.net,DDN17DCP2VV,Ap #643-8904 Ac Street",
//            "Michelle W. Richmond, 16710415,5598 ,056 9482 4078,aptent.taciti@mi.com,DYO26KFA7GN, 5996 Nec, Road" ,
//            "Daquan I. Burns, 16760521,7376 ,(016977) 0758,convallis.convallis.dolor@enim.net,VOZ75UFJ8FV,215 Gravida St.",
//            "Fritz Y. Becker, 16260629,9770 ,0388 703 0207,felis@dolor.com,QOO05GYH5ON, P.O. Box 139, 2705 Nulla. St. ",
//            "Tyler W. Tucker, 16250506,7369 ,07016 077420,quis.lectus.Nullam@elementumpurusaccumsan.edu,LLV21CEH9DK, P.O. Box 680, 3154 Risus. Ave" ,
//            "Dexter S. Bridges, 16910417,7952 ,0845 46 45,turpis.vitae@nondapibus.com,WQZ45DWD2OY,943-8147 Pede Street",
//            "Jenette N. Kent, 16540226,1225 ,0800 694153,et.tristique@nislsemconsequat.edu,WHW98EVU3LQ,609-7801 Integer Rd."
//            Gillian J. Hurst, 16020101,0626 ,07993 970852,cursus@temporlorem.ca,AQP31KUL5YB, P.O. Box 271, 729 Arcu Ave
//            Georgia M. Harrington, 16410108,1422 ,056 5505 4422,Nunc.lectus.pede@duinecurna.edu,JWR57QYH0XY,Ap #760-7998 In Avenue
//            Thane W. Craig, 16711228,2624 ,0856 720 4965,Pellentesque.ultricies.dignissim@arcu.edu,UVK53ABH0HM, P.O. Box 682, 9932 Lacus. Street
//            Yoshi G. Frazier, 16950603,3886 ,056 0867 1410,lorem.luctus.ut@nostra.org,TYR72EJS3FM,495-5840 Cras Street
//            Valentine F. Huber, 16250303,3280 ,(0115) 067 2292,quam@eliteratvitae.org,RKO96NAV8VG, P.O. Box 775, 6481 Sem Av.
//            Taylor Y. Oliver, 16120419,2155 ,070 7079 5408,ultrices.posuere@nonleoVivamus.edu,DXX79FEE7MO,5034 Felis Rd.
//            Dorian N. Vinson, 16520214,7517 ,0500 238733,hendrerit.Donec.porttitor@eratVivamus.com,JIQ53ATD1QU, P.O. Box 933, 7266 Urna, Street
//            Kylynn U. Flowers, 16630125,4899 ,(0118) 063 6780,interdum@magnaLoremipsum.org,EYG26IEI5KM,835 Feugiat Ave
//            Gareth T. Fitzpatrick, 16631210,7946 ,0937 734 7446,erat.neque.non@nonummyipsum.net,BMK58PZM1IR,7227 Quis St.
//            Damon H. Dunlap, 16180412,6041 ,0303 530 5602,neque.Sed@cursus.com,ARY20QVV7FQ,Ap #921-6701 Aliquam St.
//            Gary D. Murphy, 16950513,7639 ,076 5931 5428,Integer.eu.lacus@egetmetus.co.uk,URB55MAV4KX, 967-7167 Eleifend, Avenue
//            Harlan Q. Clay, 16940419,7668 ,0500 544261,vel.quam.dignissim@pellentesque.edu,JCZ55PLZ1YL, P.O. Box 949, 2754 Nec Av.
//            Chloe X. Vinson, 16711010,1404 ,0500 807562,nisl@variuset.com,LSM53ZWX7NM,Ap #308-5525 Lacinia. Av.
//            Harper S. Hines, 16800830,7962 ,0829 047 5634,lorem.semper.auctor@Inmipede.co.uk,ETK49IGJ1AP,478-3839 Lacus Rd.
//            Paki E. Shaffer, 16570908,1094 ,070 8088 4695,Nullam@nuncsit.ca,TRX30LVF8DH,6565 Eleifend Av.
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
