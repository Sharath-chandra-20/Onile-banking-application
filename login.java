package online.banking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton login, signup, clear;
    JTextField CardTextField;
    JPasswordField PinTextField;
    
    Login() {
        setTitle("AUTOMATED TELLER MACHINE");
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(80, 20, 100, 100);
        add(label);
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(250, 50,500, 30);
        add(text);
        
        JLabel Cardnumber = new JLabel("Card No:");
        Cardnumber.setFont(new Font("Raleway", Font.BOLD, 28));
        Cardnumber.setBounds(150, 200,590, 30);
        add(Cardnumber);
        
         CardTextField = new JTextField();
        CardTextField.setBounds(290, 200, 260, 30);
        CardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(CardTextField);
        
        JLabel Pin = new JLabel("PIN:");
        Pin.setFont(new Font("Osward", Font.BOLD, 28));
        Pin.setBounds(190, 260,590, 30);
        add(Pin);
        
        PinTextField = new JPasswordField();
        PinTextField.setBounds(290,260,260,30);
        PinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(PinTextField);
        
         login = new JButton("SIGN IN");
         login.setBounds(300, 350, 100, 30);
         login.setBackground(Color.blue);
         login.setForeground(Color.white);
         login.addActionListener(this);
         add(login);
        
         clear = new JButton("CLEAR");
         clear.setBounds(450, 350, 100, 30);
         clear.setBackground(Color.blue);
         clear.setForeground(Color.white);
         clear.addActionListener(this);
         add(clear);
         
         signup = new JButton("SIGNUP");
         signup.setBounds(300, 400, 250, 30);
         signup.setBackground(Color.blue);
         signup.setForeground(Color.white);
         signup.addActionListener(this);
         add(signup);
         
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800,500);
        setVisible(true);
        setLocation(250,100);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == clear) {
            CardTextField.setText("");
            PinTextField.setText("");
        } else if (ae.getSource() == login) {
            Conn conn = new Conn();
            String cardnumber = CardTextField.getText();
            String Pin = PinTextField.getText();
            String query = "select * from login where cardnumber = '"+cardnumber+"' and Pin = '"+Pin+"'";
            try {
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Transaction().setVisible(true);
                } else {
                    
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == signup){
            setVisible(false);
            new SignupOne().setVisible(true);
            
        }
        
    }
    
    public static void main(String args[]){
        new Login();
    }
}
