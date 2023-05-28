package online.banking;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import java.sql.*;

public class Transaction extends JFrame implements ActionListener{

    JLabel l1;
    JLabel b1,b2,b3,b4,b5,b6;
    JButton b7;
    //String pin;
    Transaction(String String){
        //this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 0, 900, 900);
        add(l2);
        
        l1 = new JLabel("Please Select Your Transaction");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 18));
        
       
        b1 = new JLabel("DEPOSIT");
        b2 = new  JLabel("CASH WITHDRAWL");
        b3 = new JLabel("FAST CASH");
        b4 = new JLabel("MINI STATEMENT");
        b5 = new JLabel("PIN CHANGE");
        b6 = new JLabel("BALANCE ENQUIRY");
        b7 = new JButton("EXIT");
        
        setLayout(null);
        
        l1.setBounds(200,310,700,35);
        l2.add(l1);
        
        b1.setBounds(180,410,150,35);
        l2.add(b1);
        b1.setForeground(Color.WHITE);
        
        b2.setBounds(390,410,150,35);
        l2.add(b2);
        b2.setForeground(Color.WHITE);
        
        b3.setBounds(180,440,150,35);
        l2.add(b3);
        b3.setForeground(Color.WHITE);
        
        b4.setBounds(390,440,150,35);
        l2.add(b4);
        b4.setForeground(Color.WHITE);
        
        b5.setBounds(180,470,150,35);
        l2.add(b5);
        b5.setForeground(Color.WHITE);
        
        b6.setBounds(390,470,150,35);
        l2.add(b6);
        b6.setForeground(Color.WHITE);
        
        b7.setBounds(390,510,100,35);
        l2.add(b7);
        b7.addActionListener(this);
        b7.setForeground(Color.WHITE);
        b7.setBackground(Color.BLACK);
        
        //b1.addActionListener(this);
        //b2.addActionListener(this);
        //b3.addActionListener(this);
        //b4.addActionListener(this);
        //b5.addActionListener(this);
        //b6.addActionListener(this);
        //b7.addActionListener(this);
        
        
        setSize(900,800);
        setLocation(200,20);
        setUndecorated(true);
        setVisible(true);
        
        
        
    }
    public void actionPerformed (ActionEvent ae){
        if (ae.getSource() == b7) {
            System.exit(0);
        }
    }
    
   
    
    public static void main(String[] args){
        new Transaction("").setVisible(true);
    }
}