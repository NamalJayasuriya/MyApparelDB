/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBInterface;

import EntityDB.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author namal
 */
public class DBControler {
    String url = "jdbc:mysql://localhost:3306/pos";
    String username = "root";
    String password = "";
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs=null;
    
    PreparedStatement pst1;
    PreparedStatement pst2;
    
    public static void main(String [] args){
        //User usr = new User("u1","namal", "padukka", 0712626607, "pwd","01");
        UserControl ucon = new UserControl();
        //ucon.createUser(usr);
        
        System.out.println(ucon.getUser("namal").getUserName());
    }
    
}
