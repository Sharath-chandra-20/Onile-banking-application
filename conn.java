package online.banking;

import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
    public Conn() {
        try {
            
            c = DriverManager.getConnection("jdbc:mysql:///onlinebanking", "root", "2005");
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
