package shop.domain.repository;

import shop.domain.entity.Seller;

import java.util.ArrayList;

public class SellerRepository {
    private Seller[] sellers;

    public ArrayList<Seller> getSellersBySalary (double salary) {
        ArrayList<Seller> sellersBySalary = new ArrayList<Seller>();
        for (int  i = 0; i < sellers.length; i++) {
            if (sellers[i].getSalary() == salary)
                sellersBySalary.add(sellers[i]);
        }
        return sellersBySalary;
    }

    public ArrayList<Seller> getSellersByWorkProgram (int[] workProgram) {
        ArrayList<Seller> sellersByWorkProgram = new ArrayList<Seller>();
        for (int  i = 0; i < sellers.length; i++) {
            int[] sellerWorkProgram = sellers[i].getWorkProgram();
            boolean ok = true;
            for (int j = 0; j < sellerWorkProgram.length; i++) {
                if (sellerWorkProgram[j] != workProgram[j]) {
                    ok = false;
                    break;
                }
            }
            if (ok == true)
                sellersByWorkProgram.add(sellers[i]);
        }
        return sellersByWorkProgram;
    }
}
