package shop.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterface extends JFrame{
    private JPanel mainPanel;
    private JButton logInBtn;
    private JButton addCustomerBtn;
    private JButton listProteinConcBtn;
    private JButton avbProteinBtn;
    private JButton avbVitaminBtn;
    private JButton producersBtn;
    private JButton srcVitBtn;

    public UserInterface() throws HeadlessException {

        add(mainPanel);
        pack();
        setTitle("Supplements Shop");
        //setSize(400, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        logInBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginDialog loginDlg = new LoginDialog();
                loginDlg.setVisible(true);
                // if logon successfully

            }
        });
    }
}
